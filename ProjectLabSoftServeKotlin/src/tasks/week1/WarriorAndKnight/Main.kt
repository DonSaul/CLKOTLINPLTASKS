package tasks.week1.WarriorAndKnight

fun main() {
    val warrior = Warrior()
    val knight = Knight()
    val result = fight(warrior, knight)
    if (result) println("The Knit was defeated, the winner is the warrior") else println("The warrior was defeated, the winner is the KNIGHT!")
}

