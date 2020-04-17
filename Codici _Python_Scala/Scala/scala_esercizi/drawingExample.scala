// C:/scalaExamples/drawingExample.scala-----> 

//scalac -cp . drawingExample.scala ( eseguo il file )

import shapes._ // importo il package 

ShapeDrawingActor.start() // inizio la comunicazione (ShapeDrawingActo= è il regista degli attori)

 // comunico all' attore il messaggio
ShapeDrawingActor ! new Circle(new Point(0.0,0.0), 1.0) // disegna un cerchio...
ShapeDrawingActor ! new Rectangle(new Point(0.0,0.0), 2, 5)
ShapeDrawingActor ! new Triangle(new Point(0.0,0.0),
                                 new Point(1.0,0.0),
                                 new Point(0.0,1.0))
ShapeDrawingActor ! 3.14159 // disegna un numero ( mi darà errore)

ShapeDrawingActor ! "exit" // lo faccio uscire dal loop

