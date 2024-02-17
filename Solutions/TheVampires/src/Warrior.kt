open class Warrior() {
    open var health: Int = 50
        protected set

    protected open val attack: Int = 5

    val isAlive: Boolean
        get() = health > 0

    open fun hit(opponent: Warrior) {
        opponent.receiveDamage(attack)
    }

    protected open fun receiveDamage(damage: Int) {
        health -= damage
    }
}