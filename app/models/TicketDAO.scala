package models

import anorm._
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
(id: Long,
 description: String,
 status: String,
 createdAt: Date,
 updatedAt: Date,
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

}
