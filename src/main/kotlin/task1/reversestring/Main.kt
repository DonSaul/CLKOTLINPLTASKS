package org.softserve.task1.reversestring

/**
 * To reverse the given input, I have used a mutable list and used it as a stack
 * iterating through each character of the input I added it to the beggining of the list.
 * Once all the characters are added to the list, it is already reversed so the only step aside is
 * to join the list on a String using the .joinToString method.
 */
fun reverseString(texto:String): String  {
    val reversedList: MutableList<Char> = mutableListOf()
    for (i in 0 until texto.length) {
        reversedList.addFirst(texto[i])
    }
    println(texto) // Prints the input to compare with the output
    return reversedList.joinToString(separator="")
}


fun main() {
    println(reverseString("Rey pirata"))
}


