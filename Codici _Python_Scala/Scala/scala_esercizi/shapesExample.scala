// C:/scalaExamples/shapesExample.scala -----> actorExample.scala

// scalac shapesExample.scala actorExample.scala  ( comando per compilare il package)
package shapes {
  class Point(val x: Double, val y: Double) {
    override def toString() = "Point(" + x + "," + y + ")"
  }

  abstract class Shape() { // la classe astratta non si istanzia. Si usa solo per erditarietà
    def draw(): Unit
  }

  // il campo center è definito con la classe Point
  class Circle(val center: Point, val radius: Double) extends Shape {
    def draw() = println("Circle.draw: " + this) // this=parametro "se stesso" . Stampo la classe stessa 
    override def toString() = "Circle(" + center + "," + radius + ")"
  }

  class Rectangle(val lowerLeft: Point, val height: Double, val width: Double)
        extends Shape {
    def draw() = println("Rectangle.draw: " + this)
    override def toString() =
      "Rectangle(" + lowerLeft + "," + height + "," + width + ")"
  }

  class Triangle(val point1: Point, val point2: Point, val point3: Point)
        extends Shape {
    def draw() = println("Triangle.draw: " + this)
    override def toString() =
      "Triangle(" + point1 + "," + point2 + "," + point3 + ")"
  }
}