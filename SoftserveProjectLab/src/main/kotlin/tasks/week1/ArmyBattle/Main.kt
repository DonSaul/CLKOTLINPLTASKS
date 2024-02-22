package org.example.tasks.week1.ArmyBattle

fun main() {

    val myArmy = Army()
    myArmy.addUnits(1) { Healer() }
    myArmy.addUnits(3) {Dwarfs()}


    val enemyArmy = Army()
    enemyArmy.addUnits(3) { Orcs() }
    enemyArmy.addUnits(1) {Lancer()}

/*
    val fellowship = Army()
    fellowship.addUnits(3) { Dwarfs() }
    fellowship.addUnits(3) { Orcs() }
    fellowship.addUnits(1) { Defender() }

    val vampiresArmy = Army()
    val defendersArmy = Army()

    val fellowshipVsEnemy = fight(fellowship, enemyArmy)
    val vampiresVsDefender = fight(vampiresArmy, defendersArmy)
    */
    val myFirstFight = fight(myArmy, enemyArmy)
    println("My Army: ")
    myArmy.printUnits()

    println("Enemy")
    enemyArmy.printUnits()

    if (myFirstFight) println("The winner is: myArmy") else println("The winner is: EnemyArmy")
//    if (fellowshipVsEnemy) println("Result of the Epic battle: FellowShip wins") else println("Result of the Epic battle: Enemy wins")
//    if (vampiresVsDefender) println("vampiresVsDefender: vampire wins") else println("vampiresVsDefender: defender wins")

}

