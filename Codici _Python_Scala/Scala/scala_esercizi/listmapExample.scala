// C:/scalaExamples/listmapExample.scala


var factor = 3 // dichiaro var cosi posso mutare factor--> var=mutabile

val multiplier = (i:Int) => i * factor

// map è una funzione nativa e quindi non devo fare list.map multiplier, ma list map multiplier
val l1 = List(1, 2, 3, 4, 5) map multiplier 

factor = 5
val l2 = List(1, 2, 3, 4, 5) map multiplier

println(l1)
println(l2)