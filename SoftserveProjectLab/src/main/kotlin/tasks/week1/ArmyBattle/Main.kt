package org.example.tasks.week1.ArmyBattle

fun main() {

    val battle = Battle()
    val army1 = Army()
    val army2 = Army()

    army1.addUnits(4) { Lancer() }
    army1.addUnits(3) { Dwarfs() }
    army1.addUnits(1) { Healer() }
    army1.addUnits(4) { Dwarfs() }
    army1.addUnits(1) { Healer() }
    army1.addUnits(2) { Orcs() }

    army2.addUnits(4) { Dwarfs() }
    army2.addUnits(4) { Defender() }
    army2.addUnits(1) { Healer() }
    army2.addUnits(2) { Vampire() }
    army2.addUnits(4) { Lancer() }

    val winner = battle.straightFight(army1, army2)
    println("Tha winner is: ${if (winner) "Army1" else "Army2"}")

//    val myArmy = Army()
//    myArmy.addUnits(7) {Lancer()}
//    myArmy.addUnits(3) {Vampire()}
//    myArmy.addUnits(1) {Healer()}
//    myArmy.addUnits(4) {Dwarfs()}
//    myArmy.addUnits(1) {Healer()}
//    myArmy.addUnits(2) {Defender()}
//
//
//    val enemyArmy = Army()
//    enemyArmy.addUnits(4) {Dwarfs()}
//    enemyArmy.addUnits(4) {Defender()}
//    enemyArmy.addUnits(1) {Healer()}
//    enemyArmy.addUnits(6) {Vampire()}
//    enemyArmy.addUnits(4) {Lancer()}


//    val myFirstFight = fight(myArmy, enemyArmy)
//    println("My Army: ")
//    myArmy.printUnits()
//
//    println("Enemy: ")
//    enemyArmy.printUnits()

//    if (myFirstFight) println("The winner is: myArmy") else println("The winner is: EnemyArmy")
}

