// C:/scalaExamples/traitExample.scala

// creazione di classi e tratti. Il workflow è quello scritto , quindi il tutto viene eseguito nell'ordine di creazione(PIPELINE).
// il risultato del println ci permette esattamente di capire il workflow da seguire in Scala.
trait T1 {
  println("  in T1: x = " + x)
  val x = 1
  println("  in T1: x = " + x)
}
trait T2 {
  println("  in T2: y = " + y)
  val y = "T2"
  println("  in T2: y = " + y)
}

class Base12 {
  println("  in Base12: b = " + b)
  val b = "Base12"
  println("  in Base12: b = " + b)
}

// Quindi, in questo caso, la classe figlia diventa un gestore(controllore) della PIPELINE
class C12 extends Base12 with T1 with T2 {
  println("  in C12: c = " + c)
  val c = "C12"
  println("  in C12: c = " + c)
}
println(" La PIPELINE eseguita :")

println("Sto creando C12:")
new C12
println("Dopo aver creato C12")