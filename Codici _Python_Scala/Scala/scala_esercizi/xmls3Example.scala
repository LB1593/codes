// C:/scalaExamples/xmls3Example.scala

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

someXML match {
  case <sandwich>{ingredients @ _*}</sandwich> => {
    for (cond @ <condiments>{_*}</condiments> <- ingredients)
      println("condimenti: " + cond.text)
  }
}
