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
        println("$name attacked ${target.name} using ${attackPoints} damage.")
    }
}

fun main() {
    val character1 = Character("Thorin Oakshield", 200, 150)
    val character2 = Character("Kili", 200, 90)

    println("${character1.name}\nHealth: ${character1.healtPoints}\nAttack: ${character1.attackPoints}")
    println("------VS------")
    println("${character2.name}\nHealth: ${character2.healtPoints}\nAttack: ${character2.attackPoints}")
    println()
    character1.attack(character2)
    println("${character1.name}\nHealth: ${character1.healtPoints}\nAttack: ${character1.attackPoints}")
    println("--------------")
    println("${character2.name}\nHealth: ${character2.healtPoints}\nAttack: ${character2.attackPoints}")
}