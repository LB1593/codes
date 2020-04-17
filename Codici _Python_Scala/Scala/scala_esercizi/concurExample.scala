// C:/scalaExamples/concurExample.scala

import java.util.concurrent._

class ThreadIdentifier extends Runnable {
  def run {
    println("ciao dal Thread " + pool)
  }
}

var a = 0

var pool = Executors.newFixedThreadPool(1)

for (i <- 1 to 5) {
  pool = Executors.newFixedThreadPool(i)
  pool.execute(new ThreadIdentifier)
  println("indice = " + i)
    for (i <- 1 to 1000000000) {
        a = a + 1
    }
}

println("premere ctrl-c per uscire")