package org.softserve.task1.fizzbuzz

/**
 * First of all, for better readability, using the extension functionality I added the
 * methods necesary to check if the given number is divisible by 3, 5 or both.
 * Then, through a "when" statement it verifies wich requirement meets and prints the given value.
 *
 * Usefull learning:
 * - The ".." operator, that create inclusive ranges, including the max number in the iteration.
 * - The "extension functionality", that allows to add new funtionality to a class without creating a new one
 *   or using decorators.
 */

fun Int.isDivisibleBy3(): Boolean =  this % 3 == 0
fun Int.isDivisibleBy5(): Boolean =  this % 5 == 0
fun Int.isDivisibleByBoth(): Boolean = this.isDivisibleBy3() && this.isDivisibleBy5()

fun fizzBuzz(max:Int) {
    for (i in 1..max) {
        when {
            i.isDivisibleByBoth() -> println("$i FizzBuzz")
            i.isDivisibleBy5() -> println("$i Buzz")
            i.isDivisibleBy3() -> println("$i Fizz")
            else -> println(i)
        }
    }
}

fun main() {
    fizzBuzz(20)
}
