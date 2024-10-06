
fun main() {
    val mobiles = mutableListOf("Google Pixel","Galaxy A54","Iphone 13")
        .apply {
            removeIf { mobil -> mobil.contains("Google") }
        }
    println(mobiles)

    val colors : MutableList<String> = mutableListOf("Red","Blue")
    colors.apply {
        println("Our colors are $this")
        println("This list has $size colors")
    }
}