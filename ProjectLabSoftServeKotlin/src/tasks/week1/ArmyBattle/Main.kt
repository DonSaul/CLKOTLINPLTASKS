package tasks.week1.ArmyBattle

import java.sql.DriverManager.println

fun main() {
    val legolas = Dwarfs()
    val gimli = Dwarfs()
    val aragorn = Defender()

    val myArmy = Army()
    myArmy.addUnits(3) { Dwarfs() }

    val fellowship = Army()
    fellowship.addUnits(3) { legolas }
    fellowship.addUnits(3) { gimli }
    fellowship.addUnits(1) { aragorn }

    val enemyArmy = Army()
    enemyArmy.addUnits(5) { Orcs() }

    val newArmy = Army()
    newArmy.addUnits(100) { Dwarfs() }
    newArmy.addUnits(200) { Orcs() }

    val newArmy2 = Army()
    newArmy2.addUnits(44) { Dwarfs() }

    val epicBattle = fight(fellowship, enemyArmy)

    println("Dwarfs Vs Orcs 1: ${fight(myArmy, enemyArmy)}")
    println("Second Battle: ${fight(newArmy, newArmy2)}")
    println("Result of the Epic battle: $epicBattle")

}

