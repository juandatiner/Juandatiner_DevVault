
fun main() {

    val myLambda : (String) -> Int = { value -> value.length } // {it} is a default value
    val executeLambda : Int = myLambda("Hi") // get the value of the Lambda
    println(executeLambda)

    // as parameter
    val regards = listOf("Hello","Hola","Ola")
    val lengthOfRegards = regards.map (myLambda) //call lambda
    println(lengthOfRegards)
}