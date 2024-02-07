class Character(
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
    fun attack(target: Character) {
        target.takeDamage(attackPoints)
        println("$name attack ${target.name} using ${attackPoints} damage.")
    }
}

fun main() {
    val character1 = Character("Kili", 200, 90)
    val character2 = Character("Thorin Oakshield", 200, 120)


    println("${character1.name}\nHealth: ${character1.healthPoints}\nAttack: ${character1.attackPoints}")
    println("------VS------")
    println("${character2.name}\nHealth: ${character2.healthPoints}\nAttack: ${character2.attackPoints}")
    println()
    while (character2.healthPoints > 0 && character1.healthPoints > 0) {
        println("----------------")
        character1.attack(character2)
        println("Health: ${character1.healthPoints}")
        println("--------------")
        println("${character2.name} was injured\nHealth: ${character2.healthPoints}")
        println("----------------")
        character2.attack(character1)
        println("Health: ${character2.healthPoints}")
        println("----------------")
        println("${character1.name} was injured\nHealth: ${character1.healthPoints}")
        println("----------------")
    }
    if (character1.healthPoints > 0) {
        println("${character2.name} has been defeated\nThe winner is ${character1.name}")
    } else {
        println("${character1.name} has been defeated\nThe winner is ${character2.name}")
    }
}