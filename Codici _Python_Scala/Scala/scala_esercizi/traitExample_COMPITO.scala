
// imposto la pipeline con il corretto workflow

// classe parent 
class Editoria {
  
    println("Categoria editoriale : Letteratura scientifica")
    println("Casa editrice : Mondadori ")
}


// classe trait che estende classe parent
trait Info {

    //val info="info"
    println("Autore : Luca Bernardini")
    println("Nazionalità : Italiana ")
    println("Genere letterario :  Informatica")
    println("Data di pubblicazione : 15/10/2012 ")
    println("Titolo : Programmare in Scala")
    println("Abstract : Programmazione OOP e funzionale")
    
}

// classe child che erdita classe parent
class Libro extends Editoria  with Info {
}

// stampa a video del documento
println("\nPresentazione Libro :")
println(" \n-------------------------------------")
new Libro // istanza delle classe child
println("\n-------------------------------------")