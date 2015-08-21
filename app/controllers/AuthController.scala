package controllers

import com.google.inject.Inject
import play.api.cache.{Cache, CacheApi}
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import services.UserService
import utils.{LoggerHelper, FutureHelper}
import play.api.Play.current
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by anand on 17/8/15.
 */
class AuthController @Inject()(userService: UserService, cacheApi: CacheApi) extends Controller with LoggerHelper {

  /**
   * Render login page
   *
   * @return
   */
  def login = Action { implicit request =>
    Ok(views.html.login("CSR-System: Login")).withNewSession
  }

  /**
   * Remove user from session and redirect for login
   *
   * @return
   */
  def logout = Action { implicit request =>
    Redirect(routes.AuthController.login).withNewSession.flashing("SUCCESS" -> "You have successfully logout. Thanks")
  }

  def loginForm = Form(tuple("email" -> email, "password" -> nonEmptyText))

  /**
   * Authorize user by email and password
   *
   * @return
   */
  def auth = Action.async { implicit request =>
    FutureHelper {
      loginForm.bindFromRequest.fold(
        formWithErrors => {
          Redirect(routes.AuthController.login).flashing("ERROR" -> "Please check email/password.")
        },
        authData => {
          val (email, password) = authData
          info(s"Form Data => email: $email, password: $password")
          userService.auth(email, password) match {
            case Right(user) =>
              info(s"User Data => $user")
              cacheApi.set(email, user, 30.minutes)
              Redirect(routes.Application.index).withSession(Security.username -> email).flashing("SUCCESS" -> "Welcome to CSR-System")
            case Left(error) => Redirect(routes.AuthController.login).flashing("ERROR" -> error)
          }
        }
      )
    }.map { result => result }.recover { case ex: Exception =>
      Redirect(routes.AuthController.login).flashing("ERROR" -> "Please check email/password.")
    }
  }

}
