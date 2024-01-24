open class Character(
    var name: String,
    private var healthPoints: Int,
    private var attackPoints: Int
) {
    fun getHealthPoints(): Int {
        if (healthPoints == 0){
            println("Your $name is dead!")
        }
        return healthPoints

    }

    fun getAttackPoints(): Int {
        println("$attackPoints of $name")
        return attackPoints
    }

    open fun takeDamage(damage: Int) {
        healthPoints -= damage
    }

    open fun attack(target: Character) {
        println("$name makes an attack to ${target.name}")
        target.takeDamage(attackPoints)
    }

}

class Wizard(name: String, healthPoints: Int, attackPoints: Int, private var manaPoints: Int) :
    Character(
        name, healthPoints,
        attackPoints
    ) {

    private val magicalAttackCost = 10
    override fun attack(target: Character) {
        if (manaPoints >= magicalAttackCost) {
            magicalAttack(target)
        } else {
            println("$name doesn't have enough mana to make a magical spell, so he is doing a regular attack!")
            super.attack(target)
        }
    }

    private fun magicalAttack(target: Character) {
        manaPoints -= magicalAttackCost

        val magicalDamage = getAttackPoints()
        target.takeDamage(magicalDamage)
        println("$name casts a magical spell on ${target.name} for $magicalDamage damage!")
    }

}

fun main() {
    val warrior = Character("Ragnar", 100, 15)
    val wizard = Wizard("Loki", 100, 20, 20)
   
    warrior.attack(wizard)
    wizard.attack(warrior)
    wizard.attack(warrior)
    warrior.attack(wizard)
    warrior.attack(wizard)
    warrior.attack(wizard)
    wizard.attack(warrior)
    wizard.attack(warrior)
    warrior.getHealthPoints()
    wizard.getHealthPoints()
}
