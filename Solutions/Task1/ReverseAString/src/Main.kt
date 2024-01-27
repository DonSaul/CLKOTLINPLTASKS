fun main() {
    println(reverseString("Hello, World!"))
}

fun reverseString(str: String): String {
    return str.reversed();
}

fun reverseStringManual(str: String): String {
    val reversed = StringBuilder();
    for(i in str.length - 1 downTo 0) {
        reversed.append(str[i]);
    }
    return reversed.toString()
}