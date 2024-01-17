package task1

class Solver {


    fun fizzBuzz(number:Int){

        for (i in 1..number){
            when {
            i%3==0 && i%5==0 -> println("FizzBuzz.")
            i%3==0-> println("Fizz.")
            i%5==0-> println("Buzz.")
            else -> println(i)

            }
        }


    }
    fun reverse(string:String):String{
        return string.reversed()
    }

    fun findMissing(arr:Array<Int>):Int{

        val sorted= arr.sorted()
        var missing=-1

        for (i in 0..sorted.size){
            if (sorted[i]!=i){
                missing=i
                break
            }
        }

        return missing


    }
}