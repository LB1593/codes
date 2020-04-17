// C:/scalaExamples/simulationExample.scala

package sleepingbarber

import scala.actors.Actor._
import scala.collection.{immutable, mutable}
import scala.util.Random

object BarbershopSimulator {
  private val random = new Random()
  private val customers = new mutable.ArrayBuffer[Customer]()
  private val shop = new Shop()

  def generateCustomers {
    for (i <- 1 to 20) {
      val customer = new Customer(i)
      customer.start()
      customers += customer
    }

    println("[!] genero " + customers.size + " clienti")
  }

  // i clienti arrivano a intervalli di tempo casuali
  def trickleCustomers {
    for (customer <- customers) {
      shop ! customer
      Thread.sleep(random.nextInt(450))
    }
  }

  def tallyCuts {
    // attende la terminazione delle rimanenti azioni concorrenti
    Thread.sleep(2000)

    val shornCount = customers.filter(c => c.shorn).size
    println("[!] oggi sono stati serviti " + shornCount + " clienti")
  }

  def main(args: Array[String]) {
    println("[!] inizio la simulazione del salone da barbiere")
    shop.start()

    generateCustomers
    trickleCustomers
    tallyCuts

    System.exit(0)
  }
}