// C:/scalaExamples/upmainExample.scala

object Upper {

  // args :, permette di inserire gli attributi nel metodo. In questo caso è un main perchè logic. sarà il metodo principale.
  // il met. vuole sempre l'uguale
  def main(args: Array[String]) = {
    args.map(_.toUpperCase()).foreach(printf("%s ",_)) 
    println("")
  } 
}
