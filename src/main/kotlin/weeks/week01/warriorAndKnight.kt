
open class Warrior(
    var health: Int = 50,
    val attack: Int = 5
) {
    val isAlive: Boolean
        get() = health > 0

    open fun receiveDamage(damage: Int) {
        health -= damage
        if (health < 0) {
            health = 0
        }
    }
}

class Knight : Warrior(health = 50, attack = 7)

fun fight(warrior1: Warrior, warrior2: Warrior): Boolean {
    var currentAttacker = warrior1
    var currentDefender = warrior2

    while (warrior1.isAlive && warrior2.isAlive) {
        currentDefender.receiveDamage(currentAttacker.attack)
        //swap
        val temp = currentAttacker
        currentAttacker = currentDefender
        currentDefender = temp
    }

    return warrior1.isAlive
}

fun main() {
    val warrior = Warrior()
    val knight = Knight()

    val result = fight(warrior, knight)

    if (result) {
        println("The warrior wins")
    } else {
        println("The knight wins")
    }
}

