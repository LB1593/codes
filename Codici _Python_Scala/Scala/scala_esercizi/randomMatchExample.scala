import scala.util.Random

val randomInt = new Random().nextInt(10)

randomInt match {
    
    case 3 => println("numero desiderato")
    case otherNumber => println(" numero non desiderato:" + otherNumber)


}

println(" number:" + randomInt )