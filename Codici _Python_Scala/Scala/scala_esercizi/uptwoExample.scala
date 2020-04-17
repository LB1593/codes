// C:/scalaExamples/uptwoExample.scala

// utilizzo un object non ereditabile e che non può costruire un istanza.

object Upper { 
   def upper(strings: String*) = strings.map(_.toUpperCase())
}

println(Upper.upper("Un", "Primo", "Programma", "Scala")) 


// utilizzo una classe erditabile in cui posso creare istanza

/*class Upper {
   // strings* mi serve per leggere stringhe di lunghezza variabile

   def upper(strings:String*)={

   // map legge una stringa, passando un intero a toUpperCase. _. mi permette di non ripetere l'argomento strings

    strings.map(_.toUpperCase()) 

val words= new Upper
println(words.upper("primo","nome"))*/