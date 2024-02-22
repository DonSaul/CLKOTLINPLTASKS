package org.example.tasks.week1.ArmyBattle

class Defender() : UnitArmy() {
    override val attack: Int = 3
    private val defense: Int = 2

    init {
        health = 60
    }

    override fun getMaxHealth(): Int {
        return 60
    }

    override fun damage(damage: Int) {
        val actualDamage = maxOf(0, damage - defense)
        health -= actualDamage
    }

}

class Rockie() : UnitArmy() {
    override val attack: Int = 1
    override fun getMaxHealth(): Int {
        return 60
    }

    init {
        health = 60
    }

    override fun damage(damage: Int) {
        health -= damage
    }
}