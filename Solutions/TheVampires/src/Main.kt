
fun main() {
    val firstArmy = Army()
    firstArmy.addUnits(3) { Knight() }

    val secondArmy = Army()
    secondArmy.addUnits(10) { Warrior() }

    val isFirstArmyWinner = battle(firstArmy, secondArmy)

    println(if(isFirstArmyWinner) "First Army wins!" else "Second Army wins!")
}

fun battle(firstArmy: Army, secondArmy: Army) : Boolean {

    while(firstArmy.units.isNotEmpty() && secondArmy.units.isNotEmpty()) {

        val firstWarrior: Warrior = firstArmy.units.first()
        val secondWarrior: Warrior = secondArmy.units.first()

        val isFirstWarriorWinner = fight(firstWarrior, secondWarrior)

        if(isFirstWarriorWinner) {
            secondArmy.units.removeFirst()
        } else {
            firstArmy.units.removeFirst()
        }
    }

    return firstArmy.units.isNotEmpty()
}

fun fight(firstWarrior: Warrior, secondWarrior: Warrior) : Boolean {
    var attacker: Warrior = firstWarrior
    var defender: Warrior = secondWarrior

    while(attacker.isAlive) {
        attacker.hit(defender)
        attacker = defender.also { defender = attacker }
    }

    return firstWarrior.isAlive
}