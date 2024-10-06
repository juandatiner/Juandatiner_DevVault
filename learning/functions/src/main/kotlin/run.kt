
fun main() {

    val mobiles = mutableListOf("Google Pixel","Galaxy A54","Iphone 13")
        .run {
            removeIf { mobil -> mobil.contains("Google") }
            this
        }
    println(mobiles)
}