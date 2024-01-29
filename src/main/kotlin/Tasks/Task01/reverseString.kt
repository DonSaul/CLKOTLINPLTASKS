fun reverseString(input: String): String {
    return input.reversed()
}

fun main() {
    val inputString = "Hello, World!"
    val reversedString = reverseString(inputString)
    println("Input: $inputString")
    println("Output: $reversedString")
}