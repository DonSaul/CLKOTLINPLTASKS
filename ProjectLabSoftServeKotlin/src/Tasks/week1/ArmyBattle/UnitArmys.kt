package Tasks.week1.ArmyBattle

abstract class UnitArmy {
    var health: Int = 0
    abstract val attack: Int
    val isAlive: Boolean
        get() = health > 0

    abstract fun damage(damage: Int)
}
