
fun main() {

    val fruitList = listOf("Apple","Pineapple","Pear","Peach")

    for (fruit in fruitList) println("Today I'm going to eat $fruit") //compressed syntax

    fruitList.forEach { fruit -> println("Today I'm going to eat a new fruit named $fruit") } //anonymous function

    val fruitCharacters : List<Int> = fruitList.map { fruit -> fruit.length }
    println(fruitCharacters)

    val filteredList = fruitCharacters.filter { fruitLength -> fruitLength > 5 }
    println(filteredList)
}