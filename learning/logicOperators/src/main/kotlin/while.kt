
fun main(){

    var counter = 10

    while (counter > 0) {

        println("The counter value is $counter")
        counter--

    }

    do {

        println("Generating a random number...")
        val randomNumber = (0..100).random()
        println("The random number is $randomNumber")

    } while (randomNumber != 1 or 2 or 3)
}
