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
        println("$name attacked ${target.name} for ${attackPoints} damage.")
    }
}

