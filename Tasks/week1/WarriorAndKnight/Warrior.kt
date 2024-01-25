open class Warrior() {
    var health: Int = 20
    open val attack: Int = 1
    val isAlive: Boolean
        get() = health > 0

    fun damage(damage:Int) {
        health -= damage
    }
}
