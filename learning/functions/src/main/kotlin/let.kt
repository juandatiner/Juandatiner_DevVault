
fun main() {

    var name: String? = null
    name?.let { value -> println("The name isn't null, is $value") }

    name = "David"
    println("The name isn't null, is $name")

}