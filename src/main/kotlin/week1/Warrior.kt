package week1;

open class Warrior (open var health:Int=50,open var attack:Int=5){
    val isAlive: Boolean
        get() = health > 0
}
