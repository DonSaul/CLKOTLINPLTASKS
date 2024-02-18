class Vampire: Warrior(health = 40) {
    override val attack: Int
        get() = 4
    private val vampirism: Int
        get() = 50

    override fun hits(opponent: Warrior) {
        val healthBefore = opponent.health
        super.hits(opponent)
        val damageDealt = healthBefore - opponent.health
        val healthPoints = damageDealt * vampirism / 100
        healBy(healthPoints)
    }
}