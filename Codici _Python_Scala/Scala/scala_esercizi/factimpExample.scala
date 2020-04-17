// C:/scalaExamples/factimpExample.scala
// IMPLEMENTAZIONE IMPERATIVA

// si può vedere il confronto per l'iterazione , con listmapExample.scala

def factorial_loop(i: BigInt): BigInt = {
  var result = BigInt(1)
  for (j <- 2 to i.intValue) 
    result *= j
  result
}

for (i <- 1 to 10)
  println(i, factorial_loop(i))
