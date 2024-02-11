package org.example.tasks.week1.ArmyBattle

class Lancer: UnitArmy() {
    override val attack: Int = 6
    init {
        health = 50
    }
    override fun attack(units: List<UnitArmy?>) {
        super.attack(units)
        if (units.size > 1) {
            val damageDealt = minOf(attack / 2, units[1]?.health ?: 0)
            units[1]?.damage(damageDealt)
        }
    }
    override fun damage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }
}