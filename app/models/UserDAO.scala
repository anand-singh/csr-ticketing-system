package models

import java.util.{Date}
import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import scala.language.postfixOps

case class User(id: Long, name: String, designation: String, email: String, password: String, isAdmin: Boolean)

/**
 * Created by anand on 17/8/15.
 */
class UserDAO {

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
      case id ~ name ~ designation ~ email ~ password ~ isAdmin =>
        User(id, name, designation, email, password, isAdmin)
    }
  }

  // -- Queries

  /**
   * Retrieve an user by given user id
   *
   * @param id
   * @return
   */
  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user where id = {id}").on('id -> id).as(user.singleOpt)
    }
  }

  /**
   * Retrieve an user by given user email
   *
   * @param email
   * @return
   */
  def findByEmail(email: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user where email = {email}").on('email -> email).as(user.singleOpt)
    }
  }

  /**
   * Retrieve all user
   *
   * @return
   */
  def findAll(): List[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user").as(user *)
    }
  }

}
