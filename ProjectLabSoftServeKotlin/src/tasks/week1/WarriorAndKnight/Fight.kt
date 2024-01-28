package tasks.week1.WarriorAndKnight

fun fight(warrior: Fighter, knight: Fighter): Boolean {
    println("--Warrior Vs Knight--")
    println("Warrior health: ${warrior.health} || Level attack of warrior: ${warrior.attack}")
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
