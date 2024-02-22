package org.example.tasks.week1.ArmyBattle

class Healer : UnitArmy() {
    override val attack: Int = 0

    init {
        health = 60
    }
    override fun getMaxHealth(): Int {
        return 60
    }



    fun heal(unit: UnitArmy) {
        unit.health = minOf(unit.health + 2, unit.getMaxHealth())
    }

    override fun damage(damage: Int) {
        health -= damage
    }

    override fun attack(units: List<UnitArmy?>) {
        val target = units.firstOrNull()
        if (target != null) {
            heal(target)
        }
    }
}