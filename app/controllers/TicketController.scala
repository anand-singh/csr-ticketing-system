package controllers

import com.google.inject.Inject
import models.{TicketDetail, Ticket, User}
import play.api.cache.CacheApi
import play.api.mvc.Controller
import services.{CustomerService, TicketService, UserService}
import utils.{FutureHelper, LoggerHelper, AuthHelper}

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by anand on 19/8/15.
 */
class TicketController @Inject()
(cacheApi: CacheApi, uService: UserService, tService: TicketService, cService: CustomerService)
  extends AuthHelper(cacheApi) with Controller with LoggerHelper {

  def tickets = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    FutureHelper {
      (uService.getUsers(), tService.getAllTicket())
    }.map { case (users, tickets) =>
      Ok(views.html.tickets.list("Tickets", user, users.map(u => (u.id -> u)).toMap, tickets))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok(views.html.tickets.list("Tickets", user, Map.empty[Long, User], List.empty[Ticket]))
    }
  }

  /**
   *
   * @param id
   * @return
   */
  def ticketDetails(id: Long) = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    FutureHelper {
      for {
        ticketDetail <- for {
          ticket <- tService.getTicketById(id)
          createdBy <- uService.getUserById(ticket.createdBy)
          assignedTo <- uService.getUserById(ticket.assignedTo)
          customer <- cService.getCustomerById(ticket.customerId)
        } yield TicketDetail(ticket, createdBy, assignedTo, customer)
        ticketDetailWithComments <- Some(ticketDetail)
      } yield ticketDetailWithComments
    }.map { ticketDetail =>
      Ok(views.html.tickets.ticketDetail(ticketDetail.get))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok("Ticket not found for given id!!!")
    }
  }

}
