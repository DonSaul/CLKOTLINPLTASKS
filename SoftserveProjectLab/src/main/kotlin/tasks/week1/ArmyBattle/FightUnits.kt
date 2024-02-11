package org.example.tasks.week1.ArmyBattle

import java.sql.DriverManager.println

fun fight(army1: Army, army2: Army): Boolean {
    println("===== Battle Start =====")
    println("Army 1 vs Army 2")
    while (army1.firstSurvivedUnit() != null && army2.firstSurvivedUnit() != null) {
        val unit1 = army1.firstSurvivedUnit()!!
        var unit2 = army2.firstSurvivedUnit()!!
        println("----- Turn Start -----")
        println("Unit from Army 1 attacks Unit from Army 2")
        println("Health before attack: Army 1 = ${unit1.health}, Army 2 = ${unit2.health}")
        unit1.attack(listOf(unit2))
        if (unit2.health <= 0) {
            army2.killFirstUnit()
            if (army2.firstSurvivedUnit() == null) {
                break
            }
            unit2 = army2.firstSurvivedUnit()!!
        }
        println("Unit from Army 2 attacks Unit from Army 1")
        unit2.attack(listOf(unit1))
        println("Health after attack: Army 1 - ${unit1.health}, Army 2 - ${unit2.health}")
        if (unit1.health <= 0) {
            army1.killFirstUnit()
        }
        println("----- Turn End -----\n")
    }
    val winner = if (army1.firstSurvivedUnit() != null) "Army 1" else "Army 2"
    println("===== Battle End =====")
    println("Winner: $winner")
    return army1.firstSurvivedUnit() != null
}
