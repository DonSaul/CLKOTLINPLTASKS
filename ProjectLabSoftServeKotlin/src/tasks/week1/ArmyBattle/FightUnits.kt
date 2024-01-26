package tasks.week1.ArmyBattle

fun fight(army1: Army, army2: Army): Boolean {
    while (army1.firstSurvivedUnit() != null && army2.firstSurvivedUnit() != null) {
        val unit1 = army1.firstSurvivedUnit()!!
        val unit2 = army2.firstSurvivedUnit()!!

        while (unit1.isAlive && unit2.isAlive) {
            unit2.damage(unit1.attack)
            if (unit2.isAlive) {
                unit1.damage(unit2.attack)
            }
        }
        army1.killFirstUnit()
        army2.killFirstUnit()
    }
    return army1.firstSurvivedUnit() != null
}