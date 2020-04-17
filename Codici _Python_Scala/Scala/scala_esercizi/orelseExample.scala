// C:/scalaExamples/orelseExample.scala

val truthier: PartialFunction[Boolean, String] = { case true => "veritiero" }
val fallback: PartialFunction[Boolean, String] = { case x => "approssimativo" }
val tester = truthier orElse fallback

println(tester(1 == 1))
println(tester(2 + 2 == 5))

