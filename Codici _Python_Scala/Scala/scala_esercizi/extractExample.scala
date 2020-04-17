
// filtro la lista con filter

val stateCapitals = Map(
  "Alabama" -> "Montgomery",
  "Alaska"  -> "Juneau",
  "Wyoming" -> "Cheyenne")

println(stateCapitals filter { kv =>kv._1 startsWith "A"})
