package controllers

import com.google.inject.Inject
import play.api.cache.CacheApi
import play.api.mvc._
import utils.{LoggerHelper, AuthHelper}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(cacheApi: CacheApi) extends AuthHelper(cacheApi) with Controller with LoggerHelper {

  def index = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    Future(Ok(views.html.index("Your new application is ready.", user)))
  }

}
