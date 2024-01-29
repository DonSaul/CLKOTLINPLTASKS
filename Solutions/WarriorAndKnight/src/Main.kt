
fun main() {
    val knight = Knight()
    val warrior = Warrior()

    println(if(fight(knight, warrior)) "Knight wins!" else "Warrior wins!")
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