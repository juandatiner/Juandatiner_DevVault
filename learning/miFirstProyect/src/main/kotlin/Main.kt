package org.example

const val PI = 3.1416  //constant
fun main( args: Array<String>) {
    println("Hello World!")

    var money = 10    //var is a usual variable

    println(money)
    money = 5
    println(money)

    val named = "Maria" //var is a final variable

    println(named)
    println(PI)

    val boolean = true
    val longNumber = 300000000000
    val double = 2.48
    val float = 1.2f

    val firstValue = 2
    val secondValue = 3
    val thirdValue = firstValue.minus(secondValue)
    //or
    val fourthValue = firstValue + secondValue

    println(thirdValue)
    println(fourthValue)

    val lastName = "Rincon"
    val name = "Juan"
                        // name + " " + lastName
    val completeName = "$name $lastName" //text chain

    println(completeName)
    println("Mi nombre es $completeName") //interpolation
}