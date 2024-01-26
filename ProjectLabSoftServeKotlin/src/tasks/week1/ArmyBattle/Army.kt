package tasks.week1.ArmyBattle

class Army {
    private val unitsArmy: MutableList<UnitArmy> = mutableListOf()
    fun addUnits(count: Int, unitCreation: () -> UnitArmy) {
        repeat(count) {
            unitsArmy.add(unitCreation.invoke())
        }
    }

    fun firstSurvivedUnit(): UnitArmy? {
        return unitsArmy.firstOrNull { it.isAlive }
    }

    fun killFirstUnit() {
        unitsArmy.removeAll { !it.isAlive }
    }
}