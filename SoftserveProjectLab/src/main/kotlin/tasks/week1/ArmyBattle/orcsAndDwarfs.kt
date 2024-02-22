package org.example.tasks.week1.ArmyBattle

class Orcs : UnitArmy() {
    override val attack: Int = 7

    init {
        health = 50
    }

    override fun getMaxHealth(): Int {
        return 50
    }


    override fun damage(damage: Int) {
        health -= damage
    }
}

class Dwarfs : UnitArmy() {
    override val attack: Int = 5
    init {
        health = 50
    }
    override fun getMaxHealth(): Int {
        return 50
    }

    override fun damage(damage: Int) {
        health -= damage
    }
}