package models

import java.util.Date

import anorm._
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

/**
 * Created by anand on 18/8/15.
 */
trait DAOParsers {

  // -- Parsers

  /**
   * Parse an User from a ResultSet
   */
  val user = {
    get[Long]("users.id") ~
      get[String]("users.name") ~
      get[String]("users.designation") ~
      get[String]("users.email") ~
      get[String]("users.password") ~
      get[Boolean]("users.is_admin") map {
      case id ~ name ~ designation ~ email ~ password ~ isAdmin => User(id, name, designation, email, password, isAdmin)
    }
  }

  /**
   * Parse a Comment from a ResultSet
   */
  val comment = {
    get[Long]("comments.id") ~
      get[Long]("comments.ticket_id") ~
      get[String]("comments.comment") ~
      get[Date]("comments.created_at") ~
      user map {
      case id ~ ticketId ~ comment ~ createdAt ~ user => Comment(id, user, ticketId, comment, createdAt)
    }
  }

}
