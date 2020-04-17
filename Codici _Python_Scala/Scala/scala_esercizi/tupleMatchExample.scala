val tupA = ("Ciao","Luca")
val tupB = ("buongiorno","Matteo")

for(tup <- List(tupA,tupB)) {

    tup match {

        case (thingOne,thingTwo) if thingOne== "Ciao" => println("una tupla che comincia con 'Ciao'")

        case (thingOne,thingTwo) => println("Questa contiene due cose :'" + thingOne + " e " + thingTwo)

    }

}
