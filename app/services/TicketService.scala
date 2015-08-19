package services

import com.google.inject.Inject
import models.{Ticket, TicketDAO, UserDAO}
import utils.LoggerHelper

/**
 * Created by anand on 19/8/15.
 */
class TicketService @Inject()(ticketDAO: TicketDAO) extends LoggerHelper {

  def getAllTicket(): List[Ticket] = {
    ticketDAO.findAll()
  }

  def getTicketDetails(): Map[String, Int] = {
    info("Get all ticket details called")
    val ticketMap = ticketDAO.findAll().groupBy(t => t.status)
    ticketMap.map { case (key, values) => (key -> values.size) }
  }

}
