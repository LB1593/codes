 // C:/scalaExamples/xmls2Example.scala

import scala.xml._

val someXML =
<sandwich>
  <bread>integrale</bread>
  <meat>salame</meat>
  <condiments>
    <condiment expired="true">maionese</condiment>
    <condiment expired="false">mostarda</condiment>
  </condiments>
</sandwich>

println("------------------------------------")
println("FILE XML:")
println(someXML)
println("------------------------------------")

// verifica che si tratta effett, di un XML e non di una stringa
assert(someXML.isInstanceOf[scala.xml.Elem]) 