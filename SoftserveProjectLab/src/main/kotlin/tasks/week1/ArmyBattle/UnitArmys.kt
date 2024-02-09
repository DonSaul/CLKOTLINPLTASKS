package org.example.tasks.week1.ArmyBattle

abstract class UnitArmy {
    var health: Int = 0
    abstract val attack: Int

    open fun attack(units: List<UnitArmy>) {
        units.firstOrNull()?.damage(attack)
    }
    val isAlive: Boolean
        get() = health > 0

    abstract fun damage(damage: Int)
}
