
fun main() {
    val firstArmy = Army()
    firstArmy.addUnits(3) { Knight() }

    val secondArmy = Army()
    secondArmy.addUnits(10) { Warrior() }

    val isFirstArmyWinner = battle(firstArmy, secondArmy)

    println(if(isFirstArmyWinner) "First Army wins!" else "Second Army wins!")
}

fun battle(firstArmy: Army, secondArmy: Army) : Boolean {
    var result = true

    for ((attacker, defender) in firstArmy.champions zip secondArmy.champions) {
         result = fight(attacker, defender)
    }

    return result
}

fun fight(firstWarrior: Warrior, secondWarrior: Warrior) : Boolean {
    var (attacker, defender) = firstWarrior to secondWarrior

    while(attacker.isAlive) {
        attacker hits defender
        attacker = defender.also { defender = attacker }
    }

    return firstWarrior.isAlive
}