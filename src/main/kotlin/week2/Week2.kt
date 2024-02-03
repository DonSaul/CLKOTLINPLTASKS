package week2

import kotlin.math.round

fun fight(warrior1: Warrior, warrior2: Warrior):Boolean{
    fun attack(attacker: Warrior, defender: Warrior){
        defender.takeDamage(attacker.attack)
    }
    var round =1
    while (true){
        println("Round : ${round}")
        attack(warrior1,warrior2)
        if (!warrior2.isAlive){
            return true
        }
        attack(warrior2,warrior1)

        if (!warrior1.isAlive){
            return false
        }

        println("Warrior 1 health: ${warrior1.health}")
        println("Warrior 2 health: ${warrior2.health}")
        round++
    }

}

fun fight(attackingArmy: Army, defendingArmy: Army):Boolean{

    while (true){

        fight(attackingArmy.units.first, defendingArmy.units.first)

        if (!attackingArmy.units.first.isAlive){
            attackingArmy.units.removeFirst()
        } else{
            defendingArmy.units.removeFirst()
        }
        if (attackingArmy.units.isEmpty()){
            return false
        } else if (defendingArmy.units.isEmpty()){
            return true
        }
    }

}



fun main () {
    // smoke test
    val chuck = Warrior()
    val bruce = Warrior()
    val carl = Knight()
    val dave = Warrior()
    val mark = Warrior()
    val bob = Defender()
    val mike = Knight()
    val rog = Warrior()
    val lancelot = Defender()

    check(fight(chuck, bruce) == true)
    check(fight(dave, carl) == false)
    check(chuck.isAlive == true)
    check(bruce.isAlive == false)
    check(carl.isAlive == true)
    check(dave.isAlive == false)
    check(fight(carl, mark) == false)
    check(carl.isAlive == false)
    check(fight(bob, mike) == false)
    check(fight(lancelot, rog) == true)

    val myArmy = Army()
    myArmy.addUnits(1) { Defender() }

    val enemyArmy = Army()
    enemyArmy.addUnits(2) { Warrior() }

    val army3 = Army()
    army3.addUnits(1) { Warrior() }
    army3.addUnits(1) { Defender() }

    val army4 = Army()
    army4.addUnits(2) { Warrior() }

    check(fight(myArmy, enemyArmy) == false)
    check(fight(army3, army4) == true)
    println("OK")


}