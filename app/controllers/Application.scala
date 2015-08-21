package controllers

import com.google.inject.Inject
import models.User
import play.api.cache.CacheApi
import play.api.mvc._
import services.{TicketService, UserService}
import utils.{AuthHelper, FutureHelper, LoggerHelper}

import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(cacheApi: CacheApi, uService: UserService, tService: TicketService)
  extends AuthHelper(cacheApi) with Controller with LoggerHelper {

  /**
   * Render the Dashboard page of the application
   *
   * @return
   */
  def index = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    FutureHelper {
      (uService.getUsers(), tService.getTicketDetails())
    }.map { case (users, tickets) =>
      Ok(views.html.index("Dashboard", user, users, tickets))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok(views.html.index("Dashboard", user, List.empty[User], Map[String, Int]()))
    }
  }

}
