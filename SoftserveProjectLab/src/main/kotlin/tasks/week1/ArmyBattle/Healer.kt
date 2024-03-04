package org.example.tasks.week1.ArmyBattle

class Healer : UnitArmy() {
    override val attack: Int = 0
    private val healAmount: Int = 2
    init {
        health = 60
    }
    fun healStraight(unit: UnitArmy) {
    }
    override fun getMaxHealth(): Int {
        return 60
    }
    override fun attack(units: List<UnitArmy?>) {
        val target = units.firstOrNull()
        if (target != null && target.health < target.getMaxHealth()) {
            heal(target)
        }
    }
    fun heal(target: UnitArmy) {
        target.health = minOf(target.health + healAmount, target.getMaxHealth())
    }

    override fun damage(damage: Int) {
        health -= damage
    }
}