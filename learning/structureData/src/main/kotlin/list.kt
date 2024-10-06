
fun main() {

    val namesList = listOf("Juan","Enrique","Camila") //immutable
    println(namesList)

    val emptyList = mutableListOf<String>() //mutable
    println(emptyList)

    emptyList.add("Danna")
    emptyList.add("Michelle")
    println(emptyList)

    val valueUseGet = emptyList.get(0)  // form to get #1
    println(valueUseGet)

    val valueUseOperator = emptyList[1] // form to add #2
    println(valueUseOperator)

    val firstValue = namesList.firstOrNull() //return the first element but if the list is empty return a {null}
    println(firstValue)

    emptyList.removeAt(0)
    println(emptyList)

    emptyList.add("Paula")
    println(emptyList)
    emptyList.removeIf { character -> character.length > 4}
    println(emptyList)

}