fun main() {
    (1..100).forEach {
        println(
            when {
                it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
                it % 3 == 0 -> "Fizz"
                it % 5 == 0 -> "Buzz"
                else -> it
            }
        )
    }
}