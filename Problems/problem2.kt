//Reverse String

fun stringReversed(string: String): String {
    return string.reversed()
}

fun main() {
    val normalString = "I'm not in danger skyler, I'm the danger"
    val reversedString = stringReversed(normalString)
    println("Normal: $normalString")
    println("Reversed: $reversedString")
}