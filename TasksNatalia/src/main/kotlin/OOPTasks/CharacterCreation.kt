open class Character(val name: String, var healthPoints: Int, val attackPoints: Int) {
    fun takeDamage(damage: Int) {
        healthPoints -= damage
        println("$name took a damage of $damage, current HP is $healthPoints")
    }

    open fun attack(target: Character) {
        println("$name hit ${target.name}! Did $attackPoints points of damage")
        target.takeDamage(attackPoints)
    }
}

class Wizard(name: String, healthPoints: Int, attackPoints: Int, var manaPoints: Int) :
    Character(name, healthPoints, attackPoints) {

    fun attack(target: Character, attackType: String) {
        if (attackType == "spell") {
            if (manaPoints < 20) {
                println("Spell failed, $name doesn't have enough mana points")
            } else {
                println("$name casted a magic spell on ${target.name}! Made ${attackPoints * 10} points of damage")
                target.takeDamage(attackPoints * 10)
                manaPoints -= 20
            }
        } else if (attackType == "attack" || attackType == "") {
            println("$name hit ${target.name}! Made $attackPoints points of damage")
            target.takeDamage(attackPoints)
        }
    }
}

fun main() {
    val char1 = Character("John", 100, 20)
    val char2 = Character("Milo", 120, 20)
    val char3 = Wizard("Lumina", 70, 5, 60)

    println("Character 1: name: ${char1.name} health: ${char1.healthPoints} attack: ${char1.attackPoints}")
    println("Character 2: name: ${char2.name} health: ${char2.healthPoints} attack: ${char2.attackPoints}")
    println("Character 3: name: ${char3.name} health: ${char3.healthPoints} attack: ${char3.attackPoints} mana: ${char3.manaPoints}")
    println()
    char1.attack(char3)
    char2.attack(char3)
    char3.attack(char2, "spell")
    char3.attack(char2, "spell")
    char3.attack(char1, "spell")
    println()
    char3.attack(char2)
    char3.attack(char2, "spell")
    char3.attack(char1, "attack")
    println()
    println("name: ${char1.name} health:${char1.healthPoints} attack: ${char1.attackPoints}")
    println("name: ${char2.name} health:${char2.healthPoints} attack: ${char2.attackPoints}")
    println("name: ${char3.name} health:${char3.healthPoints} attack: ${char3.attackPoints} mana: ${char3.manaPoints}")

}
