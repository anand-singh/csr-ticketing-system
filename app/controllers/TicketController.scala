package controllers

import com.google.inject.Inject
import models.{Customer, TicketDetail, Ticket, User}
import play.api.cache.CacheApi
import play.api.mvc.Controller
import services.{CommentService, CustomerService, TicketService, UserService}
import utils.{FutureHelper, LoggerHelper, AuthHelper}
import play.api.data._
import play.api.data.Forms._

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

  /**
   * Render create ticket form with required data
   *
   * @return
   */
  def createFormView = withAuth { user => implicit request =>
    info(s"Session user data: $user")
    val futurePageData = for {
      users <- FutureHelper(uService.getUsers)
      customers <- FutureHelper(cService.getAllCustomer)
    } yield (users, customers)

    futurePageData.map { case (users, customers) =>
      Ok(views.html.tickets.create("Tickets", user, users, customers))
    }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Ok(views.html.tickets.create("Tickets", user, List.empty[User], List.empty[Customer]))
    }
  }

  def ticketForm = Form(
    tuple(
      "description" -> nonEmptyText,
      "area" -> nonEmptyText,
      "assignedTo" -> longNumber,
      "customerId" -> longNumber
    ))

  /**
   * Handle create ticket form data
   *
   * @return
   */
  def create = withAuth { user => implicit request =>
    info(s"Create form called with session user data: $user")
    FutureHelper {
      ticketForm.bindFromRequest.fold(
        formWithErrors => {
          Redirect(routes.TicketController.createFormView).flashing {
            "ERROR" -> "Oops! Please check the form data."
          }
        },
        ticketData => {
          val (description, area, assignedTo, customerId) = ticketData
          info(s"Form Data => $description, $area, $assignedTo, $customerId")
          val ticketObj = Ticket(description = description, area = area,
            customerId = customerId, createdBy = user.id, assignedTo = assignedTo)
          val result = tService.createTicket(ticketObj) match {
            case Right(tObj: Ticket) => ("SUCCESS" -> "Ticket has been created successfully.")
            case Left(error) => ("ERROR" -> error)
          }
          Redirect(routes.TicketController.tickets).flashing(result)
        }
      )
    }.map { result => result }.recover { case ex: Exception =>
      error(ex.getMessage, ex)
      Redirect(routes.TicketController.tickets).flashing {
        "ERROR" -> "Oops! There is some problem with server. Please try after some time."
      }
    }
  }

}
