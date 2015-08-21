package models

import java.util.Date

import anorm._
import play.api.db.DB
import java.util.{Date}
import play.api.Play.current
import scala.language.postfixOps
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

case class Comment(id: Long, user: User, ticketId: Long, comment: String, createdAt: Date)

/**
 * Created by anand on 18/8/15.
 */
class CommentDAO extends DAOParsers {

  /**
   * Find all comment by given ticketId
   *
   * @param ticketId
   * @return
   */
  def findByTicketId(ticketId: Long): List[Comment] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
        select * from comments c
        join users u on u.id = c.user_id
        where c.ticket_id = {ticket_id}
        """
      ).on('ticket_id -> ticketId).as(comment *)
    }
  }


}
