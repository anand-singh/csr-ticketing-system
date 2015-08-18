package utils

import com.google.inject.Inject
import controllers.routes
import models.User
import play.api.Play.current
import play.api.cache.{Cache, CacheApi}
import play.api.mvc._

import scala.concurrent.Future

/**
 * Created by anand on 17/8/15.
 */
class AuthHelper @Inject() (cacheApi: CacheApi) {

  /**
   * This is used to get username from request
   *
   * @param request
   * @return
   */
  def username(request: RequestHeader): Option[String] = request.session.get(Security.username)

  /**
   * This is used to redirect unauthorized access to login page
   *
   * @param request
   * @return
   */
  def unauthorizedSimpleRequest(request: RequestHeader): Result = {
    Results.Redirect(routes.AuthController.login()).withNewSession
  }

  /**
   * This is used to return unauthorized response for unauthorized access
   *
   * @param request
   * @return
   */
  def unauthorizedAjaxRequest(request: RequestHeader): Result = Results.Forbidden.withNewSession


  /**
   * This method is use to validate request
   *
   * @param f
   * @return
   */
  def withAuth(f: => User => Request[AnyContent] => Future[Result]): Action[AnyContent] = {
    Action.async { implicit request =>
      val unauthorized = isAjax match {
        case true => Future.successful(unauthorizedAjaxRequest(request))
        case false => Future.successful(unauthorizedSimpleRequest(request))
      }
      username(request).map { email =>
        cacheApi.get[User](email) match {
          case Some(user: User) => f(user)(request)
          case _ => unauthorized
        }
      }.getOrElse(unauthorized)
    }
  }

  /**
   * This is used to check request type
   *
   * @param request
   * @return
   */
  private def isAjax(implicit request: RequestHeader): Boolean = {
    request.headers.get("X-Requested-With") == Some("XMLHttpRequest")
  }

}
