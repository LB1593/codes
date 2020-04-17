object Dictionary {

    def write( val key : List, val value : List ) ={
        
        key=[str_nome]
        value=[nome]
        dizionario=[key,val]
        dizionario foreach { kv => println(kv.1 + ":" + kv.2) }


    }

}

val diz= new Dictionary

println(diz.write("Nome","Luca"))