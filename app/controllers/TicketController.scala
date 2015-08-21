package controllers

import com.google.inject.Inject
import models.{TicketDetail, Ticket, User}
import play.api.cache.CacheApi
import play.api.mvc.Controller
import services.{CommentService, CustomerService, TicketService, UserService}
import utils.{FutureHelper, LoggerHelper, AuthHelper}

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by anand on 19/8/15.
 */
class TicketController @Inject()
(cacheApi: CacheApi,
 uService: UserService,
 tService: TicketService,
 cService: CustomerService,
 cmtService: CommentService)
  extends AuthHelper(cacheApi) with Controller with LoggerHelper {

  /**
   * Render ticket list page
   *
   * @return
   */
  def tickets = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    FutureHelper {
      tService.getAllTicket()
    }.map { tickets =>
      Ok(views.html.tickets.list("Tickets", user, tickets))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok(views.html.tickets.list("Tickets", user, List.empty[Ticket]))
    }
  }

  /**
   * Render ticket details page
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
        ticketDetailWithComments <- Some(ticketDetail.copy(comments = cmtService.getCommentsByTicketId(id)))
      } yield ticketDetailWithComments
    }.map {
      case Some(ticketDetail) => Ok(views.html.tickets.ticketDetail(ticketDetail))
      case None => Ok("Ticket not found for given id!!!")
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok("Ticket not found for given id!!!")
    }
  }

}
