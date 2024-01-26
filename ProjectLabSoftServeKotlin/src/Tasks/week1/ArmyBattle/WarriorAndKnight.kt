package Tasks.week1.ArmyBattle

class Warrior:UnitArmy() {
    override val attack: Int = 5
        init {
            health = 20
        }
    override fun damage(damage: Int) {
        health -= damage
    }
}

class Knight:UnitArmy() {
    override val attack: Int = 10
    init {
        health = 30
    }

    override fun damage(damage: Int) {
        health -= damage
    }
}