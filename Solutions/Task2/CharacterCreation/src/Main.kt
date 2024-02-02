fun main() {
    val knight = Character("Knight", 350, 50)
    val wizard = Wizard("Wizard", 100, 50, 100)

    knight.attack(wizard)
    wizard.attack(knight, 140)
    knight.attack(wizard)
    wizard.attack(knight)
}

open class Character(val name: String, protected var healthPoints: Int, protected val attackPoints: Int) {

    fun takeDamage(damage: Int) {
        healthPoints = (healthPoints - damage).coerceAtLeast(0)
        println("¡$name has $healthPoints health points remaining!")
    }

    fun attack(opponent: Character) {
        if(healthPoints == 0) return

        println("¡$name attacks ${opponent.name} with $attackPoints points of damage!")
        opponent.takeDamage(attackPoints)
    }
}

class Wizard(name: String, healthPoints: Int, attackPoints: Int, private var manaPoints: Int) : Character(name, healthPoints, attackPoints) {

    fun attack(opponent: Character, manaPointsToAttack: Int) {
        if(healthPoints == 0) return

        if(manaPointsToAttack > manaPoints) {
            return println("¡The amount of mana to attack exceeds $name's mana points!")
        }

        val totalAttackPoints = attackPoints + manaPointsToAttack
        println("¡$name attacks ${opponent.name} with $totalAttackPoints points of damage!")
        opponent.takeDamage(totalAttackPoints)
        manaPoints -= manaPointsToAttack
    }
}