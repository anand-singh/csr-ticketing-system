package models

import java.util.Date

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
class TicketDAO {

}
