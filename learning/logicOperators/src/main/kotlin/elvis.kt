
fun main() {

    val name : String? = null
    val characters : Int = name?.length ?: 0  // ?: assign {0} if is null

    println(characters)

}