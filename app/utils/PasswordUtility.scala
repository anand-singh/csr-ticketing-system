package utils

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.{BASE64DecoderStream, BASE64EncoderStream}

/**
 * Created by anand on 17/8/15.
 */
class PasswordUtility extends LoggerHelper {

  /**
   * This method is used to encrypt the password.
   *
   * @param password
   * @return
   */
  def encryptPassword(password: String): String = {
    try {
      new String(BASE64EncoderStream.encode(password.getBytes()))
    } catch {
      case e: Exception => error("Error: " + e.getMessage, e); ""
    }
  }

  /**
   * This method is used to decrypt the password.
   *
   * @param password
   * @return
   */
  def decryptPassword(password: String): String = {
    try {
      new String(BASE64DecoderStream.decode(password.getBytes()))
    } catch {
      case e: Exception => error("Error: " + e.getMessage, e); ""
    }
  }

}
