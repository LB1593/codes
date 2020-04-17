// C:/scalaExamples/initExample.scala

// il tratto,non essendoci metodi, è considerato come astratto
trait AbstractT2 {
  println("In AbstractT2:")

// ho fatto un assegnazione , per gestire il tipo(Int)
  val value: Int

  val inverse = 1.0/value

  println("AbstractT2: value = " + value + ", inverse = " + inverse)
}

// ho creato un' istanza , non su una classe ,ma con  su una classe implicita(Il tratto creato).

// in alternativa avrei potuto creare una classe figlia che erditasse la class( quindi non è più trait) parent.
val c2c = new {
  // Nei blocchi di pre-inizializzazione sono permesse
  // solo le inizializzazioni.
  // println("In c2c:")
  val value = 10
} with AbstractT2 // erdito il tratto astratto

println("c2c.value = " + c2c.value + ", inverse = " + c2c.inverse)
