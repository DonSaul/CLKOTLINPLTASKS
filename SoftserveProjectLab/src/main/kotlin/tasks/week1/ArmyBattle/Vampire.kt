package org.example.tasks.week1.ArmyBattle

class Vampire : UnitArmy() {
    override val attack: Int = 4
    private val vampirism: Int = 50
    init {
        health = 40
    }

    override fun damage(damage: Int) {
        health -= damage
        heal(damage)
    }

    private fun heal(damage: Int) {
        val healAmount = damage * vampirism / 100
        health = minOf(health + healAmount, 40)
    }
}