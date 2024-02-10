fun reverseString(input: String): String {
    var result = ""
    for (i in input.length - 1 downTo 0) {
        result += input[i]
    }
    return result
}

fun main() {
    val inputString = "Hello, World!"
    val reversedString = reverseString(inputString)
    println("Input: $inputString")
    println("Output: $reversedString")
}