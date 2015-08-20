package services

import com.google.inject.Inject
import models.{TicketDAO, User, UserDAO}
import utils.LoggerHelper

/**
 * Created by anand on 17/8/15.
 */
class UserService @Inject()(userDAO: UserDAO) extends LoggerHelper {

  /**
   * Authenticate user by given email and password
   *
   * @param email
   * @param password
   * @return
   */
  def auth(email: String, password: String): Either[String, User] = {
    info(s"Auth called with email: $email, password: $password")
    userDAO.findByEmail(email).map { user =>
      info(s"User found: $user")
      user.password match {
        case `password` => Right(user)
        case _ => Left("Please check the email/password.")
      }
    }.getOrElse(Left("User not found for given email."))
  }

  /**
   * Get all user from database
   *
   * @return
   */
  def getUsers(): List[User] = {
    info("Get all user called")
    userDAO.findAll()
  }

  /**
   * Get an user by given user id
   *
   * @param id
   * @return
   */
  def getUserById(id: Long): Option[User] = {
    info(s"Get an user by id called with id: $id")
    userDAO.findById(id)
  }

}
