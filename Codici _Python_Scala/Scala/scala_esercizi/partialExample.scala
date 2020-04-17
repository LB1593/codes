// C:/scalaExamples/partialExample.scala

def concatUpper(s1: String, s2: String): String = (s1 + " " + s2).toUpperCase // in questo caso non uso le {}, perchè sing. istruzione( solo =)

val c = concatUpper _
println(c("pantaloni", "corti")) // le stringhe sono fisse 

val c2 = concatUpper("pantaloni", _: String) // la prima stringa è fissa , la seconda varaibile
println(c2("corti"))
