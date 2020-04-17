// C:/scalaExamples/foreachExample.scala

// foreach utilizza un iteratore(i) per scorrere il contenitore (List)
List(1, 2, 3, 4, 5) foreach { i => println("Int: " + i) }

//--------------------------------------------------------------------------------------
val stateCapitals = Map(
  "Alabama" -> "Montgomery",
  "Alaska"  -> "Juneau",
  "Wyoming" -> "Cheyenne")

// stampo il dizionario con key : val
stateCapitals foreach { kv => println(kv._1 + ": " + kv._2) }

