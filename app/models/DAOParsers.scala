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

  /**
   * Parse a customer from a ResultSet
   */
  val customer = {
    get[Long]("customers.id") ~
      get[String]("customers.name") ~
      get[String]("customers.email") ~
      get[String]("customers.address") ~
      get[String]("customers.contact") map {
      case id ~ name ~ email ~ address ~ contact => Customer(id, name, email, address, contact)
    }
  }

  /**
   * Parse a ticket from a ResultSet
   */
  val ticket = {
    get[Long]("tickets.id") ~
      get[String]("tickets.description") ~
      get[String]("tickets.status") ~
      get[String]("tickets.area") ~
      get[Date]("tickets.created_at") ~
      get[Date]("tickets.updated_at") ~
      get[Long]("tickets.customer_id") ~
      get[Long]("tickets.created_by") ~
      get[Long]("tickets.assigned_to") map {
      case id ~ description ~ status ~ area ~ createdAt ~ updatedAt ~ customerId ~ createdBy ~ assignedTo =>
        Ticket(id, description, status, area, createdAt, updatedAt, customerId, createdBy, assignedTo)
    }
  }

}
