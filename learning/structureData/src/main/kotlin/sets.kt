
fun main() {

    val repeatVocals = setOf("a","e","i","o","u","a","e","i","o","u") //immutable set
    println(repeatVocals) //only one time a repeat element

    val favoriteNumbers = mutableSetOf(1,2,3,4)
    println(favoriteNumbers)

    favoriteNumbers.add(1)
    favoriteNumbers.add(5)
    println(favoriteNumbers)

    favoriteNumbers.remove(1)
    println(favoriteNumbers)

    val firstNumber = favoriteNumbers.firstOrNull() { number -> number > 3 }
    println(firstNumber)
}
