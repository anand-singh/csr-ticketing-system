package services

import com.google.inject.Inject
import models.{Customer, CustomerDAO}
import utils.LoggerHelper

/**
 * Created by anand on 20/8/15.
 */
class CustomerService @Inject()(customerDAO: CustomerDAO) extends LoggerHelper {

  /**
   * Get all customer
   *
   * @return
   */
  def getAllCustomer: List[Customer] = {
    info(s"Get all customer called")
    customerDAO.findAll
  }

  /**
   * Get a customer by given customer id
   *
   * @param id
   * @return
   */
  def getCustomerById(id: Long): Option[Customer] = {
    info(s"Get customer by id called with id: $id")
    customerDAO.findById(id)
  }

}
