package org.example.tasks.week1.ArmyBattle

class Vampire : UnitArmy() {
    override val attack: Int = 4
    private val vampirism: Int = 50
    override fun getMaxHealth(): Int {
        return 40
    }
    init {
        health = 40
    }

    override fun attack(units: List<UnitArmy?>) {
        val target = units.firstOrNull()
        if (target != null) {
            val damageDealt = minOf(attack, target.health)
            target.damage(damageDealt)
            heal(damageDealt)
        }
    }
    private fun heal(damage: Int) {
        val healAmount = damage * vampirism / 100
        health = minOf(health + healAmount, 40)
    }
    override fun damage(damage: Int) {
        health -= damage
    }

}