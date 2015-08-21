package models

import play.api.db.DB
import java.util.{Date}
import play.api.Play.current
import scala.language.postfixOps
import anorm.{SQL, SqlParser}
import anorm.SqlParser._

case class Customer(id: Long, name: String, email: String, address: String, contact: String)

/**
 * Created by anand on 18/8/15.
 */
class CustomerDAO extends DAOParsers {

  /**
   * Retrieve a customer by given customer id
   *
   * @param id
   * @return
   */
  def findById(id: Long): Option[Customer] = {
    DB.withConnection { implicit connection =>
      SQL("select * from customers where id = {id}").on('id -> id).as(customer.singleOpt)
    }
  }

  /**
   * Retrieve all customer
   *
   * @return
   */
  def findAll: List[Customer] = {
    DB.withConnection { implicit connection =>
      SQL("select * from customers").as(customer *)
    }
  }

}
