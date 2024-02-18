open class Warrior(health: Int = 50) {

    private val initialHealth = health
    var health: Int = health
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }

    open val attack: Int
        get() = 5

    val isAlive: Boolean
        get() = health > 0

    open infix fun hits(opponent: Warrior) {
        opponent.receiveDamage(attack)
    }

    protected open fun receiveDamage(damage: Int) {
        health -= damage
    }

    protected fun healBy(healthPoits: Int) {
        health += healthPoits
    }
}