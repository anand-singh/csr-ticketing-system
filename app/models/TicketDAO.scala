package models

import anorm._
import play.api.db.DB
import java.util.{Date}
import play.api.Play.current
import scala.language.postfixOps
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

case class Ticket
(
  id: Long,
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

}
