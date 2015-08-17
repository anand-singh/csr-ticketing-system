package controllers

import com.google.inject.Inject
import play.api.cache.CacheApi
import play.api.mvc._
import utils.AuthHelper

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(cacheApi: CacheApi) extends AuthHelper(cacheApi) with Controller {

  def index = withAuth { user => implicit request =>
    Future(Ok(views.html.index("Your new application is ready.")))
  }

}
