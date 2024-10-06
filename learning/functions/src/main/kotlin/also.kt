
fun main() {
    val mobiles = mutableListOf("Google Pixel","Galaxy A54","Iphone 13")
        .also {
            list -> println("The original value is $list")
        }.asReversed()
    println(mobiles)
}