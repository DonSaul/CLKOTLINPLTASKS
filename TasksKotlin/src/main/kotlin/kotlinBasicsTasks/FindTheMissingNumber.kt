package main.kotlin.kotlinBasicsTasks

val numArray = arrayOf(3, 0, 1)
val maxNum = numArray.max()

fun main() {
    for (n in 0..maxNum) {
        if (n !in numArray) {
            println(n)
        }
    }
}