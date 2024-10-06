

fun main() {

    val randomPhrase = "At Platzi we never stop to learning"
    printPhase(randomCase(randomPhrase))

    val randomPhrase2 = "This is a function of extension".randomCase2()
    printPhase(randomPhrase2)
}

fun printPhase(phaser: String) : Unit { // does not return anything

    println("Your phase is: $phaser")

}

fun randomCase(phrase: String) : String { //function

    val randomNumber = 0..99
    val randomResult = randomNumber.random()

    return if (randomResult.rem(2) == 0) {  //rem = %
        phrase.uppercase()
    } else {
        phrase.lowercase()
    }
}

fun String.randomCase2() : String {  //function of extension

    val randomNumber2 = 0..99
    val randomResult2 = randomNumber2.random()

    return if (randomResult2.rem(2) == 0) {  //rem = %
        this.uppercase()
    } else {
        this.lowercase()
    }
}