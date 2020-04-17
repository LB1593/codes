// C:/scalaExamples/customerExample.scala

package sleepingbarber

import scala.actors.Actor
import scala.actors.Actor._

     case object Haircut

class Customer(val id: Int) extends Actor {
  var shorn = false

  def act() = {
                loop {
      react {
        case Haircut => {
          shorn = true
          println("[c] il cliente " + id + " � stato servito")
        }
      }
    }
  }
}
