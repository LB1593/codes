// C:/scalaExamples/actorExample.scala

// sto ampliando il package "shapes" implementato in shapesExample.scala

package shapes {

  // importo la classe Attori
  import scala.actors._ 
  import scala.actors.Actor._  
  object ShapeDrawingActor extends Actor {
    def act() { // svolge l'azione dell'attore 
      loop {  // creo un loop
        receive { // aspetta fino a che non arriva un messaggio
          case s: Shape => s.draw() // eseguio il messaggio arrivato all' attore
          case "exit"   => println("termino..."); exit // se incontro exit ho terminato 
          case x: Any   => println("Errore: messaggio sconosciuto! " + x) // errore nella ricezione del disegno
        }
      }
    }
  }
}

// Per inviare un messaggio dall'attore ,all'esterno, implemento un metodo send.