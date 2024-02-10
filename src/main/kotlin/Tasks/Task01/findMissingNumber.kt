fun findTheMissedNumber(numbers: IntArray): Int {
    for (i in 0 until numbers.size - 1) {
        if (numbers[i] + 1 != numbers[i + 1]) {
            return numbers[i] + 1
        }
    }
    return -1
}

fun main() {
    val numbers = intArrayOf(5, 0, 7)
    val missingNumber = findTheMissedNumber(numbers)

    if (missingNumber != -1) {
        println("The missing number is: $missingNumber")
    } else {
        println("No missing number found.")
    }
}