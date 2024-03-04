package org.example.tasks.week1.ArmyBattle

class Battle {

    fun straightFight(army1: Army, army2: Army): Boolean {
        while (army1.firstSurvivedUnit() != null && army2.firstSurvivedUnit() != null) {
            val roundWinner = fightRound(army1, army2)
            if (roundWinner) {
                army2.killFirstUnit()
            } else {
                army1.killFirstUnit()
            }
        }
        return army1.firstSurvivedUnit() != null
    }

    private fun fightRound(army1: Army, army2: Army): Boolean {
        val unit1 = army1.firstSurvivedUnit()!!
        val unit2 = army2.firstSurvivedUnit()!!
        while (unit1.isAlive && unit2.isAlive) {
            unit1.attack(listOf(unit2))
            if (unit2.isAlive) {
                unit2.attack(listOf(unit1))
            }
        }
        return unit1.isAlive
    }
}