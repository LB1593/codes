// l'ovveraide non si fa su classi astratte

class Notfixed { 
    // non è pormesso l' overr di un metodo final
final def fixedMethod = "fisso" 
}

class Changeable2 extends Notfixed {

override  def fixedMethod ="non fisso"

}