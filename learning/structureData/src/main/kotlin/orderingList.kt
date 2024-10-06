
fun main() {
    val lotteryNumbers = listOf(22,11,56,84,55,78)

    val sortedNumbers = lotteryNumbers.sorted()
    println(sortedNumbers)

    val descendNumbers = lotteryNumbers.sortedDescending()
    println(descendNumbers)

    val sortedByMultiples = lotteryNumbers.sortedBy { number -> number < 50 }
    println(sortedByMultiples)

    val randomNumbers = lotteryNumbers.shuffled() //aleatory order
    println(randomNumbers)

    val reversedNumbers = lotteryNumbers.reversed() //[1,2] -> [2,1]
    println(reversedNumbers)

    val messageOfNumbers = lotteryNumbers.map { number -> "Your number of lotery is $number" }
    println(messageOfNumbers)

    val filteredNumbers = lotteryNumbers.filter { number -> number > 70 }
    println(filteredNumbers)
}