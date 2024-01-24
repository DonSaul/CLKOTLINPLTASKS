package week1

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
    println("OK")

}