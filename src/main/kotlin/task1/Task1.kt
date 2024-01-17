package task1

fun main(args: Array<String>) {
    println("Task1!")

    val solver= Solver()

    solver.fizzBuzz(10)
    val stringToReverse="ABC123"

    println("Reversed:${stringToReverse.reversed()}")

    val numbers= arrayOf(1,2,3,4,5,6,7,0,9)

    println("Missing${solver.findMissing(numbers)}")

}