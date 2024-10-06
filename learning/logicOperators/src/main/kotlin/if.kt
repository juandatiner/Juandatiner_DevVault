
fun main(){

    val  name = ""

    if (name.isNotEmpty()) println("The length of our variable is: ${name.length}") else println("Error, the variable is empty")

    val message : String = if (name.length > 4) {
        "Your name is large"
    } else if (name.isEmpty()){
        "Name is empty"
    } else {
        "Your name is small"
    }

    println(message)



    
}

