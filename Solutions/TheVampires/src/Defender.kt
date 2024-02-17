class Defender: Warrior() {
    override var health: Int = 60
    override val attack: Int = 3
    private val defense: Int = 2

    override fun receiveDamage(damage: Int) {
        if (damage > defense) health -= damage - defense
    }
}