open class Warrior() {
    private var health: Int = 50
    open val attack: Int = 5
    val isAlive: Boolean
        get() = health > 0

    fun hit(opponent: Warrior) {
        opponent.health -= attack
    }
}