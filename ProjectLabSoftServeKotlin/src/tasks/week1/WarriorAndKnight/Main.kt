package tasks.week1.WarriorAndKnight

fun main() {
    val warrior = Warrior()
    val knight = Knight()
    val result = fight(warrior, knight)
    if (result) println("the winner is the warrior") else println("The winner is the knight")
}

