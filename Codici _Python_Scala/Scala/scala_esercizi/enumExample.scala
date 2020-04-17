// C:/scalaExamples/enumExample

// esempio utile per creare tabelle e farci sopre dei filtri 

// creo un oggetto perchè non mi serve avere un' ereditarietà. Nella classe enumeration ho già il metodo Value che crea id e values .
object Breed extends Enumeration { 
    val doberman = Value("Dobermann") 
    val yorkie = Value("Yorkshire Terrier") 
    val scottie = Value("Scottish Terrier") 
    val dane = Value("Alano") 
    val portie = Value("Cane d'acqua portoghese") 
}

// stampa una lista di razze con il loro identificatore
println("ID\tRazza")

for (breed <- Breed.values) 

println(breed.id + "\t" + breed)

// stampa una lista di razze Terrier 
println("\nSolo i Terrier:")

 // applico il metodo filter, sull'oggetto Breed.values che ho sostituito con _.
Breed.values.filter(_.toString.endsWith("Terrier")).foreach(println)

