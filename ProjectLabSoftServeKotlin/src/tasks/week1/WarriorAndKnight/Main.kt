package tasks.week1.WarriorAndKnight

fun main() {
    val warrior = Warrior()
    val knight = Knight()
    if (warrior.isAlive) println("The Knit was defeated, the winner is the ${warrior.name}") else println("The warrior was defeated, the winner is the ${knight.name}!")
}

