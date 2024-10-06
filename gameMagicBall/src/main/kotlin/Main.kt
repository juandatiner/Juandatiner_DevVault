import java.lang.System.exit

//values of the answers
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//join answers with the values
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)

fun main() {

    println("Welcome to Magic 8 Ball , What option do you prefer?")
    println("1. Ask a question")
    println("2. Review all the answer")
    println("3. Exit")

    val inputValue = readLine()

    when(inputValue) {
        "1" -> askQuestion()
        "2" -> showAnswers()
        "3" -> exit()
        else -> showError()
    }
}

fun showError(){
    println("Your option not is valid")
}

fun exit() {
    println("Bye")
}

fun askQuestion(){
    println("What question do you want asking?")
    readLine()
    println("Ok.. The answer to that is:")
    val generatedAnswer = answers.keys.random()
    println(generatedAnswer)
}

fun showAnswers() {
    println("Select an option")
    println("1. Review all the answers")
    println("2. Review only affirmative answers")
    println("3. Review only doubtful answers")
    println("4. Review only negative answers")

    val optionValue = readLine()
    when(optionValue) {
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(AFFIRMATIVE_ANSWER)
        "3" -> showAnswersByType(DOUBTFUL_ANSWER)
        "4" -> showAnswersByType(NEGATIVE_ANSWER)
        else -> println("Not valid Option, Bye")
    }
}

fun showAnswersByType(answerType: String = "All") {
    when(answerType) {
        "All" -> answers.keys.forEach { answer -> println(answer) }

        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { affirmativeAnswers -> println(affirmativeAnswers.keys) }

        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { negativeAnswers -> println(negativeAnswers.keys) }

        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { doubtfulAnswers -> println(doubtfulAnswers.keys) }
    }
}


