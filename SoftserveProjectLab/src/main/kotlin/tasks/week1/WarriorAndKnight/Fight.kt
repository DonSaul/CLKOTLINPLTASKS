package org.example.tasks.week1.WarriorAndKnight

fun fight(warrior: Fighter, knight: Fighter): Boolean {
    println("--${warrior.name} Vs ${knight.name}--")
    println("${warrior.name} health: ${warrior.health} || Level attack of ${warrior.name}: ${warrior.attack}")
    println("${knight.name} health: ${knight.health} || Level attack of ${knight.name}: ${knight.attack}")

    while (warrior.isAlive && knight.isAlive) {
        println("--------------------------------------------")
        println("-${warrior.name} attacks ${knight.name}!")
        knight.damage(warrior.attack)
        println("   ${warrior.name} health: ${warrior.health}")
        println("   ${knight.name} health: ${knight.health}")
        if (knight.isAlive) {
            println("--------------------------------------------")
            println("-${knight.name} attacks ${warrior.name}!")
            warrior.damage(knight.attack)
            println("   ${warrior.name} health: ${warrior.health}")
            println("   ${knight.name} health: ${knight.health}")
        }
    }
    return warrior.isAlive

}
