package week1
/*Unit fight, until one is defeated*/
fun fight(warrior1:Warrior,warrior2:Warrior):Boolean{

    fun attack(attacker: Warrior,defender: Warrior){
        defender.health-=attacker.attack

    }

    while (true){

        attack(warrior1,warrior2)

        if (!warrior2.isAlive){
            return true
        }

        attack(warrior2,warrior1)

        if (!warrior1.isAlive){
            return false
        }
    }

}
/*Army fight, until one army is defeated*/
fun fight(attackingArmy:Army,defendingArmy:Army):Boolean{

    while (true){

        fight(attackingArmy.units.first,defendingArmy.units.first)

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
    check(fight(chuck, bruce) == true) { "Warrior should win Warrior" }
    check(chuck.isAlive == true) { "Warrior winner should be alive" }
    check(bruce.isAlive == false) { "Warrior defeated should not be alive" }
    val dave = Warrior()
    val carl = Knight()
    check(fight(dave, carl) == false) { "Warrior should lose to Knight" }
    check(carl.isAlive == true) { "Knight winner should be alive" }
    check(dave.isAlive == false) { "Warrior defeated should not be alive" }
    println("Unit fight OK")

    val myArmy = Army()
    myArmy.addUnits(3) { Knight() }

    val enemyArmy = Army()
    enemyArmy.addUnits(3) { Warrior() }

    val army3 = Army()
    army3.addUnits(20) { Warrior() }
    army3.addUnits(5) { Knight() }

    val army4 = Army()
    army4.addUnits(30) { Warrior() }

    check(fight(myArmy, enemyArmy) == true)
    check(fight(army3, army4) == false)
    println("Army fight OK")




}