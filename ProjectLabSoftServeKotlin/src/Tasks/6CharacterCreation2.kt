open class Character2(
    val name: String,
    var healthPoints: Int,
    val attackPoints: Int
) {
    fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints < 0) {
            healthPoints = 0
        }
    }

    open fun attack(target: Character2) {
        target.takeDamage(attackPoints)
        println("$name attack ${target.name} using ${attackPoints} damage.")
    }
}

class Wizard(
    name: String,
    healthPoints: Int,
    attackPoints: Int,
    var manaPoints: Int
) : Character2(name, healthPoints, attackPoints) {
    override fun attack(target: Character2) {
        if (manaPoints >= 20) {
            target.takeDamage(2 * attackPoints)
            println("$name cast a spell on ${target.name} using ${2 * attackPoints} damage.")
            manaPoints -= 20
        } else {
            super.attack(target)
        }
    }
}

fun printlnBatleStatus(character: Character2) {
    println("----------------")
    println("${character.name} was injured\nHealth: ${character.healthPoints}")
    println("----------------")
}

fun main() {
    val character1 = Character2("Kili", 200, 90)
    val character2 = Wizard("Gandalf the white", 1000, 200, 100)


    println("${character1.name}\nHealth: ${character1.healthPoints}\nAttack: ${character1.attackPoints}")
    println("------VS------")
    println("${character2.name}\nHealth: ${character2.healthPoints}\nAttack: ${character2.attackPoints}")
    println()
    while (character2.healthPoints > 0 && character1.healthPoints > 0) {
        println("----------------")

        character1.attack(character2)
        println("Health: ${character1.healthPoints}")
        printlnBatleStatus(character2)

        character2.attack(character1)
        println("Health: ${character2.healthPoints}")
        printlnBatleStatus(character1)
    }
    if (character1.healthPoints > 0) {
        println("${character2.name} has been defeated\nThe winner is ${character1.name}")
    } else {
        println("${character1.name} has been defeated\nThe winner is ${character2.name}")
    }
}