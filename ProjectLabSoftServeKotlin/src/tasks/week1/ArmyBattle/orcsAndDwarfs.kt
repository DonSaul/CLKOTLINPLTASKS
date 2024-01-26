package tasks.week1.ArmyBattle

class Orcs:UnitArmy() {
    override val attack: Int = 5
        init {
            health = 20
        }
    override fun damage(damage: Int) {
        health -= damage
    }
}

class Dwarfs:UnitArmy() {
    override val attack: Int = 10
    init {
        health = 30
    }

    override fun damage(damage: Int) {
        health -= damage
    }
}