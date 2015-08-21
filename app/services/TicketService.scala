package services

import com.google.inject.Inject
import models.{Ticket, TicketDAO, UserDAO}
import utils.LoggerHelper

/**
 * Created by anand on 19/8/15.
 */
class TicketService @Inject()(ticketDAO: TicketDAO) extends LoggerHelper {

  /**
   * Get all available ticket
   *
   * @return
   */
  def getAllTicket(): List[Ticket] = {
    ticketDAO.findAll()
  }

  /**
   * Get all ticket details as map object
   *
   * @return
   */
  def getTicketDetails(): Map[String, Int] = {
    info("Get all ticket details called")
    val ticketMap = ticketDAO.findAll().groupBy(t => t.status)
    ticketMap.map { case (key, values) => (key -> values.size) }
  }

  /**
   * Get ticket by given ticket id
   *
   * @param id
   * @return
   */
  def getTicketById(id: Long): Option[Ticket] = {
    info(s"Get ticket by id called with id: $id")
    ticketDAO.findById(id)
  }

  /**
   * Create new ticket from given form data
   *
   * @param ticket
   * @return
   */
  def createTicket(ticket: Ticket): Either[String, Ticket] = {
    info(s"Create ticket called with ticket: $ticket")
    ticketDAO.create(ticket) match {
      case Some(ticketObj: Ticket) => Right(ticketObj)
      case None => Left("Oops! Error during ticket create process. Please try after some time.")
    }
  }

}
