// C:/scalaExamples/xmls1Example.scala

import scala.xml._

val someXMLInAString = """
<sandwich>
  <bread>integrale</bread>
  <meat>salame</meat>
  <condiments>
    <condiment expired="true">maionese</condiment>
    <condiment expired="false">mostarda</condiment>
  </condiments>
</sandwich>
"""

println("------------------------------------")
println("STRINGA:")
println(someXMLInAString)

// per trasformare la stringa con codice XML , in un xml uso XML.loadString("stringa"). XML è una classe del package scala.xml._
//Se avessi avuto file su disco XML.loadFile("file)
val someXML = XML.loadString(someXMLInAString) 

println("------------------------------------")
println("FILE XML:")
println(someXML)
println("------------------------------------")

//assert(someXMLInAString.isInstanceOf[scala.xml.Elem])

// verifica che si tratta effett, di un XML e non di una stringa
assert(someXML.isInstanceOf[scala.xml.Elem])  