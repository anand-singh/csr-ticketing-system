package models

import play.api.db.DB
import java.util.{Date}
import play.api.Play.current
import scala.language.postfixOps
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

case class TicketDetail
(ticket: Ticket,
 createdBy: User,
 assignedTo: User,
 customer: Customer,
 comments: List[Comment] = List.empty[Comment])

case class Ticket
(id: Long = 0L,
 description: String,
 status: String = "New",
 area: String,
 createdAt: Date = new Date(),
 updatedAt: Date = new Date(),
 customerId: Long,
 createdBy: Long,
 assignedTo: Long)

/**
 * Created by anand on 18/8/15.
 */
class TicketDAO extends DAOParsers {

  /**
   * Retrieve all user
   *
   * @return
   */
  def findAll(): List[Ticket] = {
    DB.withConnection { implicit connection =>
      SQL("select * from tickets").as(ticket *)
    }
  }

  /**
   * Retrieve a ticket by given ticket id
   *
   * @param id
   * @return
   */
  def findById(id: Long): Option[Ticket] = {
    DB.withConnection { implicit connection =>
      SQL("select * from tickets where id = {id}").on('id -> id).as(ticket.singleOpt)
    }
  }

  /**
   * Create new ticket by given ticket object
   *
   * @param ticket
   * @return
   */
  def create(ticket: Ticket): Option[Ticket] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
        INSERT INTO tickets (description, status, area, customer_id, created_by, assigned_to)
        VALUES ({description}, {status}, {area}, {customerId}, {createdBy}, {assignedTo})
        """
      ).on(
          'description -> ticket.description,
          'status -> ticket.status,
          'area -> ticket.area,
          'customerId -> ticket.customerId,
          'createdBy -> ticket.createdBy,
          'assignedTo -> ticket.assignedTo
        ).executeInsert() match {
        case Some(newId: Long) => Some(ticket.copy(id = newId))
        case None => None
      }
    }
  }

}
