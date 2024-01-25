fun findTheMissedNumber(array: IntArray): Int {
    val n = array.size
    val totalSum = n * (n + 1) / 2
    val actualSum = array.sum()
    return totalSum - actualSum
}

fun main() {
    val inputArray = intArrayOf(3, 0, 1)
    val findNumber = findTheMissedNumber(inputArray)
    println("Input: ${inputArray.joinToString(", ")}")
    println("Output: $findNumber")
}