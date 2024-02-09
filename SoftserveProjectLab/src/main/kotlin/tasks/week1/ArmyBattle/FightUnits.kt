package org.example.tasks.week1.ArmyBattle

import java.sql.DriverManager.println

fun fight(army1: Army, army2: Army): Boolean {
    println("===== Battle Start =====")
    println("Army 1 vs Army 2")

    while (army1.firstSurvivedUnit() != null && army2.firstSurvivedUnit() != null) {
        val unit1 = army1.firstSurvivedUnit()!!
        val enemyUnits = army2.survivedUnits()
        var unit2: UnitArmy? = null
        if (enemyUnits.isNotEmpty()) {
            unit2 = enemyUnits.first()
        }

        println("----- Turn Start -----")
        println("Unit from Army 1 attacks Unit from Army 2")
        println("Health before attack: Army 1 = ${unit1.health}, Army 2 = ${unit2?.health}")
        unit1.attack(enemyUnits)
        if (unit2 != null) {
            unit2.attack(army1.survivedUnits())
        }

        println("Health after attack: Army 1 - ${unit1.health}, Army 2 - ${unit2?.health}")
        println("----- Turn End -----\n")
        army1.killFirstUnit()
        army2.killFirstUnit()
    }
    val winner = if (army1.firstSurvivedUnit() != null) "Army 1" else "Army 2"
    println("===== Battle End =====")
    println("Winner: $winner")
    return army1.firstSurvivedUnit() != null
}