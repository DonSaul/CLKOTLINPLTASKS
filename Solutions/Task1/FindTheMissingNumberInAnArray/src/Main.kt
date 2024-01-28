fun main() {
    val list: List<Int> = listOf(3, 0, 1, 2, 4, 6)

    println(findMissingNumber(list))
    println(findMissingNumberBySum(list))
    println(findMissingNumberWithLambda(list))
}

fun findMissingNumber(list: List<Int>): Int {
    for(i in list.indices) {
        if(i !in list) return i
    }
    return list.size
}

fun findMissingNumberBySum(list: List<Int>): Int {
    val n = list.size
    val totalSum = n * (n + 1) / 2
    val listSum = list.sum()
    return totalSum - listSum
}

fun findMissingNumberWithLambda(list: List<Int>): Int {
    return list.indices.firstOrNull {it !in list} ?: list.size
}