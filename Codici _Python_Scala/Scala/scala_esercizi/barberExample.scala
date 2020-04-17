// C:/scalaExamples/barberExample.scala

package sleepingbarber

import scala.actors.Actor
import scala.actors.Actor._
import scala.util.Random

class Barber extends Actor {
    private val random = new Random()

    def helpCustomer(customer: Customer) {
        if (self.mailboxSize >= 3) {
            println("[b] non ci sono abbastanza sedie, mando via il cliente " + customer.id)
        } else {
            println("[b] taglio i capelli al cliente " + customer.id)
            Thread.sleep(100 + random.nextInt(400))
            customer ! Haircut
        }
    }

    def act() {
        loop {
            react {
                case customer: Customer => helpCustomer(customer)
            }
        }
    }
}
