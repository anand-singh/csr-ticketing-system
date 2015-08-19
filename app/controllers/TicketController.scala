package controllers

import com.google.inject.Inject
import models.{Ticket, User}
import play.api.cache.CacheApi
import play.api.mvc.Controller
import services.{TicketService, UserService}
import utils.{FutureHelper, LoggerHelper, AuthHelper}

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by anand on 19/8/15.
 */
class TicketController @Inject()(cacheApi: CacheApi, uService: UserService, tService: TicketService) extends AuthHelper(cacheApi) with Controller with LoggerHelper {

  def tickets = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    FutureHelper {
      (uService.getUsers(), tService.getAllTicket())
    }.map { case (users, tickets) =>
      Ok(views.html.tickets("Tickets", user, users.map(u => (u.id -> u)).toMap, tickets))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok(views.html.tickets("Tickets", user, Map.empty[Long, User], List.empty[Ticket]))
    }
  }

}
