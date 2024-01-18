package com.example.logicexercises

/*
    Exercise 1:

    The FizzBuzz test is a simple programming test often used to evaluate
    a developer's ability to write clean and efficient code.
    The task is to iterate through a range of numbers (usually from 1 to 100)
    and apply the following rules to each number:
    If the number is divisible by 3, print "Fizz."
    If the number is divisible by 5, print "Buzz."
    If the number is divisible by both 3 and 5, print "FizzBuzz."
    If none of the above conditions are met, print the number itself. 
* */

    fun main() {
    for(i in 1..100){
        if(i % 3 == 0 && i % 5 == 0){
            println("FizzBuzz")
        }
        else if(i % 3 == 0){
            println("Fizz.")
        }
        else if(i % 5 == 0){
            println("Buzz.")
        }
        else println(i)
    }
}



/*
    Exercise 2:

•   Problem: Write a function that takes a string as input and returns the string reversed.
•	Example:
•	Input: "Hello, World!"
•	Output: "!dlroW ,olleH"
*/


fun main(){
    val phrase = "Hello, World!"
    println("The original phrase: $phrase")
    println("The phrase reversed is: $phrase.reversed()")
}
 

/*
    Exercise 3:
    Problem: Given an array containing n distinct numbers
    taken from 0, 1, 2, ..., n, find the one that is missing from the array.
    Example:
    Input: [3, 0, 1]
    Output: 2

* */


fun getMissingNumber(num: IntArray): Int {

    val arrayLength = num.size
    val expectedSum = arrayLength * (arrayLength + 1) / 2
    val actualSum = num.sum()

    return expectedSum - actualSum

}

fun main() {
    val array: IntArray = intArrayOf(0, 1, 2)
    val missingNumber = getMissingNumber(array)

    println("The missing number is: $missingNumber")
}


