
fun main() {

    val ageSuperHeroes = mapOf( //immutable map
        "Iron Man" to 35,
        "Spiderman" to 43,
        "Captain America" to 99
    )
    println(ageSuperHeroes)

    val ageSuperHeroesMutable = mutableMapOf( //mutable map
        "Iron Man" to 12,
        "Spider man" to 22,
        "Captain America" to 88
    )
    println(ageSuperHeroesMutable)

    ageSuperHeroesMutable.put("Wolverine",45) // form to add #1
    println(ageSuperHeroesMutable)

    ageSuperHeroesMutable["Storm"] = 30       // form to add #2
    println(ageSuperHeroesMutable)

    val ironmanAge = ageSuperHeroesMutable["Iron Man"]
    println(ironmanAge)

    ageSuperHeroesMutable.remove("Wolverine")
    println(ageSuperHeroesMutable)

    println(ageSuperHeroesMutable.keys) //return only keys
    println(ageSuperHeroesMutable.values) // return only values

    ageSuperHeroesMutable.clear()
    println(ageSuperHeroesMutable)
}