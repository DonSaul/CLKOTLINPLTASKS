open class Character(
    val name: String,
    var healthPoints: Double,
    val attackPoints: Double
) {
    open fun takeDamage(damage: Double) {
        if (damage > 0) {
            healthPoints -= damage
            if (healthPoints < 0) {
                healthPoints = 0.0
            }
            println("$name took $damage damage. Remaining health: $healthPoints")
        } else {
            println("Invalid damage amount.")
        }
    }

    open fun attack(target: Character) {
        val damageDealt = attackPoints
        target.takeDamage(damageDealt)
        println("$name attacked ${target.name} for $damageDealt damage.")
    }
}

class Wizard(
    name: String,
    healthPoints: Double,
    attackPoints: Double,
    private var manaPoints: Double
) : Character(name, healthPoints, attackPoints) {

    private fun castSpell(target: Character, spellDamage: Double) {
        val manaCost = 8.25
        if (manaCost > manaPoints) {
            println("$name does not have enough mana to cast the spell.")
        } else {
            manaPoints -= manaCost
            target.takeDamage(spellDamage)
            println("$name casted a spell on ${target.name} for $spellDamage damage. Remaining mana: $manaPoints")
        }
    }

    override fun attack(target: Character) {
        val damageDealt = attackPoints / 3
        target.takeDamage(damageDealt)
        println("$name attacked ${target.name} for $damageDealt damage.")

        if (manaPoints >= 8.25) {
            castSpell(target, attackPoints * 1.75)
        } else {
            println("$name does not have enough mana to cast a spell.")
        }
    }
}

fun main() {
    val wizard = Wizard("Merlin", 80.0, 15.0, 50.0)
    val enemy = Character("Demon", 200.0, 20.0)

    println("${wizard.name}'s health: ${wizard.healthPoints}")
    println("${enemy.name}'s health: ${enemy.healthPoints}")

    wizard.attack(enemy)

    println("${wizard.name}'s final health: ${wizard.healthPoints}")
    println("${enemy.name}'s final health: ${enemy.healthPoints}")
}