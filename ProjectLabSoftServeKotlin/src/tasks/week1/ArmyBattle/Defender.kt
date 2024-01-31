package tasks.week1.ArmyBattle

class Defender() : UnitArmy() {
    override val attack: Int = 3
    val defense: Int = 2

    init {
        health = 60
    }

    override fun damage(damage: Int) {
        val actualDamage = maxOf(0, damage - defense)
        health -= actualDamage
    }

}