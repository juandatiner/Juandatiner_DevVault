import java.awt.image.renderable.ParameterBlock

fun main(){

    val lengthInitialValue = superFunction( "Hello", { value -> value.length })
    println(lengthInitialValue)

    val lambda: () -> String = inceptionFunction("Marisol")
    val lambdaValue: String = lambda()
    println(lambdaValue)

}

fun superFunction(initialValue: String, block: (String) -> Int): Int{

    return block(initialValue) //get Lambda
}

fun inceptionFunction(name: String) : () -> String {

    return {
        "Hello from the lambda $name"
    }
}