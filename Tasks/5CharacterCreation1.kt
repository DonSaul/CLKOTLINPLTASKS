class Character(
    val name: String,
    var healtPoints: Int,
    val attackPoints: Int
) {
    fun takeDamage(damage: Int) {
        healtPoints -= damage
        if (healtPoints < 0) {
            healtPoints = 0
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


    println("${character1.name}\nHealth: ${character1.healtPoints}\nAttack: ${character1.attackPoints}")
    println("------VS------")
    println("${character2.name}\nHealth: ${character2.healtPoints}\nAttack: ${character2.attackPoints}")
    println()
    while (character2.healtPoints > 0 && character1.healtPoints > 0) {
        println("----------------")
        character1.attack(character2)
        println("Health: ${character1.healtPoints}")
        println("--------------")
        println("${character2.name} was injured\nHealth: ${character2.healtPoints}")
        println("----------------")
        character2.attack(character1)
        println("----------------")
        println("${character1.name} was injured\nHealth: ${character1.healtPoints}")
        println("----------------")
    }
    if (character1.healtPoints > 0) {
        println("${character2.name} has been defeated\nThe winner is ${character1.name}")
    } else {
        println("${character1.name} has been defeated\nThe winner is ${character2.name}")
    }
}