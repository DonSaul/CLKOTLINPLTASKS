package tasks.week1.ArmyBattle

fun main() {
    val myArmy = Army()
    myArmy.addUnits(3) {Dwarfs()}

    val enemyArmy = Army()
    enemyArmy.addUnits(3) {Orcs()}


    val newArmy = Army()
    newArmy.addUnits(100) {Dwarfs()}
    newArmy.addUnits(200) {Orcs()}

    val newArmy2 = Army()
    newArmy2.addUnits(44) {Dwarfs()}


    println("Dwarfs Vs Orcs 1: ${fight(myArmy, enemyArmy)}")
    println("Second Battle: ${fight(newArmy, newArmy2)}")
}