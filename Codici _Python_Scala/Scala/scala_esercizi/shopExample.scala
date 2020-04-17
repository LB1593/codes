// C:/scalaExamples/shopExample.scala

package sleepingbarber

import scala.actors.Actor
import scala.actors.Actor._

class Shop extends Actor {
  val barber = new Barber()
  barber.start

  def act() {
    println("[s] il salone è aperto")

    loop {
      react {
        case customer: Customer => barber ! customer
      }
    }
  }
}