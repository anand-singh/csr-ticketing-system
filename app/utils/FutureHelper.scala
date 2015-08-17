package utils

import java.util.concurrent.TimeoutException

import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.DurationInt

import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
 * This is used to wrap a block of code into Future response
 *
 * Created by anand on 17/8/15.
 */
object FutureHelper {

  def apply[A](block: => A)(implicit timeout: FiniteDuration = 60.seconds): Future[A] = {

    val promise = scala.concurrent.Promise[A]()

    // if the promise doesn't have a value yet then this completes the future with a failure
    play.api.libs.concurrent.Promise.timeout(Nil, timeout).map(_ => promise.tryFailure(new TimeoutException("This operation timed out")))

    // this tries to complete the future with the value from block
    Future(promise.success(block))

    promise.future
  }

}
