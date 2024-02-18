class Defender: Warrior(health = 60) {
    override val attack: Int
        get() = 3
    private val defense: Int
        get() = 2

    override fun receiveDamage(damage: Int) {
        super.receiveDamage(
            (damage - defense).coerceAtLeast(0)
        )
    }
}