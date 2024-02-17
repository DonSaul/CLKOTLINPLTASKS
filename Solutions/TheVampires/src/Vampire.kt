class Vampire: Warrior() {
    override var health: Int = 40
    override val attack: Int = 4
    private val vampirism: Int = 50

    override fun hit(opponent: Warrior) {
        val opponentInitialHealth = opponent.health
        super.hit(opponent)
        val opponentFinalHealth = opponent.health

        health = (health + (opponentInitialHealth - opponentFinalHealth) * vampirism / 100).coerceAtMost(40)
    }
}