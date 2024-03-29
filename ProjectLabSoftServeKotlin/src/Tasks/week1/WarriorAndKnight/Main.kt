fun main() {
    val warrior = Warrior()
    val knight = Knight()
    val result = fight(warrior, knight)
    if (result) println("The Knit was defeated, the winner is the warrior") else println("The warrior was defeated, the winner is the KNIGHT!")
}

fun fight(warrior: Warrior, knight: Warrior): Boolean {
    println("--Warrior Vs Knight--")
    println("Warrior health: ${warrior.health} || Level attack of Warrior: ${warrior.attack}")
    println("Knight health: ${knight.health} || Level attack of Knight: ${knight.attack}")

    while (warrior.isAlive && knight.isAlive) {
        println("--------------------------------------------")
        println("-Warrior attacks Knight!")
        knight.damage(warrior.attack)
        println("   Warrior health: ${warrior.health}")
        println("   Knight health: ${knight.health}")
        if (knight.isAlive) {
            println("--------------------------------------------")
            println("-Knight attacks Warrior!")
            warrior.damage(knight.attack)
            println("   Warrior health: ${warrior.health}")
            println("   Knight health: ${knight.health}")
        }
    }
    return warrior.isAlive
}
