package controllers

import com.google.inject.Inject
import play.api.cache.{Cache, CacheApi}
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import services.UserService
import utils.FutureHelper
import play.api.Play.current

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by anand on 17/8/15.
 */
class AuthController @Inject()(userService: UserService, cacheApi: CacheApi) extends Controller {

  def login = Action {
    Ok(views.html.login("CSR-System: Login"))
  }

  def logout = Action {
    Ok(views.html.login("CSR-System: Login"))
  }

  def loginForm = Form(tuple("email" -> email, "password" -> nonEmptyText))

  def auth = Action.async { implicit request =>
    FutureHelper {
      loginForm.bindFromRequest.fold(
        formWithErrors => {
          Redirect(routes.AuthController.login).flashing("ERROR" -> "Please check email/password.")
        },
        authData => {
          val (email, password) = authData
          userService.auth(email, password) match {
            case Right(user) =>
              Cache.set(email, user)
              Redirect(routes.Application.index)
            case Left(error) => Redirect(routes.AuthController.login).flashing("ERROR" -> error)
          }
        }
      )
    }.map { result => result }.recover { case ex: Exception =>
      Redirect(routes.AuthController.login).flashing("ERROR" -> "Please check email/password.")
    }
  }

}
