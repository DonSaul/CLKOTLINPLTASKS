//FIZZ BUZZ Problem
//If i is divisible by 3 = Fizz
//If i is divisible by 5 = Buzz
//If i is divisible by 3 and 5 = FizzBuzz

fun main() {
    for (i in 1..80) {
        when {
            i % 3 == 0 && i % 5 == 0 -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}
