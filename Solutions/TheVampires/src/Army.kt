class Army {
    private val troops = mutableListOf<Warrior>()

    val champions
        get() = sequence {
            for (champion in troops)
                while (champion.isAlive)
                    yield(champion)
        }

    fun addUnits(numberOfWarriors: Int, createWarrior: () -> Warrior) {
        repeat(numberOfWarriors) {
            addUnit(createWarrior())
        }
    }

    private fun addUnit(unit: Warrior) {
        troops.add(unit)
    }
}