
fun main(){

    val colorName = "Green"

    when (colorName){

        "Yellow" -> println("The Yellow is the Happy Color")
        "Red","Carmine" -> println("The Red is the Blood Color")

        else -> println("Error. No exist information about other color")
    }

    val code = 210

    when (code) {

        in 200..299 -> println("All is good")
        in 400..500 -> println("Is good but not all")

        else -> println("All is bad")
    }

    val shoesSize = 41

    val message = when (shoesSize) {
        41,42 -> "Is in stock"
        43,44,45 -> "You are a strange"
        else -> "It not in stock"
    }

    println(message)
}