
fun main(args: Array<String>) {

    var name : String? = null //nullable variable
//
//    println(name?.length) // safe calls, return null

    try {

        name!!.length // double bang

    } catch (exception : NullPointerException) {

        println("Error")

    } finally {

        println("Closing the app")
    }

    val firstValue = 10
    val secondValue = 0
    val result : Int = try {

        firstValue/secondValue

    }catch (exception : Exception){ 0 }

    println(result)
}