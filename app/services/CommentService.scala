package services

import com.google.inject.Inject
import models.{Comment, CommentDAO}
import utils.LoggerHelper

/**
 * Created by anand on 21/8/15.
 */
class CommentService @Inject()(commentDAO: CommentDAO) extends LoggerHelper {

  /**
   * Get all comment by given ticket id
   *
   * @param ticketId
   * @return
   */
  def getCommentsByTicketId(ticketId: Long): List[Comment] = {
    info(s"Get comments by ticket id called with ticketId: $ticketId")
    commentDAO.findByTicketId(ticketId)
  }

}
