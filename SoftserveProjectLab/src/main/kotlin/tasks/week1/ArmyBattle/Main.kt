package org.example.tasks.week1.ArmyBattle

fun main() {
    val myArmy = Army()
    myArmy.addUnits(3) { Dwarfs() }

    val enemyArmy = Army()
    enemyArmy.addUnits(5) { Orcs() }

    val newArmy = Army()
    newArmy.addUnits(100) { Dwarfs() }
    newArmy.addUnits(200) { Orcs() }

    val newArmy2 = Army()
    newArmy2.addUnits(44) { Dwarfs() }

    val fellowship = Army()
    fellowship.addUnits(3) { Dwarfs() }
    fellowship.addUnits(3) { Orcs() }
    fellowship.addUnits(1) { Defender() }

    val vampiresArmy = Army()
    newArmy.addUnits(5) { Vampire() }

    val defendersArmy = Army()
    newArmy.addUnits(5) {Defender()}

    val myFirstFight = fight(myArmy, enemyArmy)
    val newArmyBattle = fight(newArmy, newArmy2)
    val fellowshipVsEnemy = fight(fellowship, enemyArmy)
    val vampiresVsDefender = fight(vampiresArmy, defendersArmy)


    if (myFirstFight) println("Dwarfs Vs Orcs: The winner is myArmy") else println("Dwarfs Vs Orcs: The winner is EnemyArmy")
    if (newArmyBattle) println("Second Battle: The winner is NewArmy") else println("Second Battle: The winner is NewArmy2")
    if (fellowshipVsEnemy) println("Result of the Epic battle: FellowShip wins") else println("Result of the Epic battle: Enemy wins")
    if (vampiresVsDefender) println("vampiresVsDefender: vampire wins") else println("vampiresVsDefender: defender wins")

}

