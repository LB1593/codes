// C:/scalaExamples/robertExample.scala

import scala.actors.Actor

class Redford extends Actor {
  def act() {
    println("Recitare consiste, in buona parte, nel prestare attenzione.")
  }
}

val robert = new Redford
robert.start

