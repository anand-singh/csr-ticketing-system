package models

import anorm._
import play.api.db.DB
import java.util.{Date}
import play.api.Play.current
import scala.language.postfixOps
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

case class User(id: Long, name: String, designation: String, email: String, password: String, isAdmin: Boolean)

/**
 * Created by anand on 17/8/15.
 */
class UserDAO extends DAOParsers {

  // -- Queries

  /**
   * Retrieve an user by given user id
   *
   * @param id
   * @return
   */
  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from users where id = {id}").on('id -> id).as(user.singleOpt)
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
      SQL("select * from users where email = {email}").on('email -> email).as(user.singleOpt)
    }
  }

  /**
   * Retrieve all user
   *
   * @return
   */
  def findAll(): List[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from users").as(user *)
    }
  }

}
