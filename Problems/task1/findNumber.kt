/**
* For this task I created two functions, the first one (missingFirstNumberFinder()),
* returns the first missing number of the ordered input, the second one (missingNumbersFinder()),
* returns a mutable list with all the missing consecutive number from the given input.
*
* Each function prints the given list sorted, to facilitate comparison of input and output.
* Both functions starts comparing the difference between the two elements starting from the index[1]
* substracting the previous element, if the result is diferent to 1 then there is a missing number.
*
* In the case missingNumbersFinder() if there is more than one consecutive number missing,
* then it adds to the list each of the consecutive missing number that are missing between two numbers.
*
* Usefull learning: the "until" operator, that create ranges, excluding the max number in the iteration.
 */

fun missingFirstNumberFinder(inputList: List<Int>): Int {
    val orderedList = inputList.sorted()
    println("Sorted list: $orderedList")
    for (i in 1 until orderedList.size) {               
        if (orderedList[i] - orderedList[i-1] != 1) { 
            return orderedList[i-1] + 1 
        }
    }
    return -1   
}

fun missingNumbersFinder(inputList: List<Int>): MutableList<Int> {
    val orderedList = inputList.sorted()
    val missingList: MutableList<Int> = mutableListOf()
    println("Sorted list: $orderedList")
    for (i in 1 until orderedList.size) {
        val difference: Int = orderedList[i] - orderedList[i-1]
        if (difference != 1) {
            for(j in 1 until difference){
                missingList.add(orderedList[i-1] + j )
            }
        }
    } 
    if (missingList.size > 0) {
        return missingList
    }
    return mutableListOf<Int>(-1)   
}

fun main() {
    val listOfNumbers: List<Int> = listOf(3,0,1,4,5,8,15)

    val missingNumber: Int = missingFirstNumberFinder(listOfNumbers)
    println("The first missing number is: $missingNumber")

    val missingNumbersList: MutableList<Int> = missingNumbersFinder(listOfNumbers)
    println("The missing number or numbers are: $missingNumbersList")
}