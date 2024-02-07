package org.example.tasks.week1.WarriorAndKnight

open class Fighter {
    open val name: String = ""
    open var health: Int = 20
    open val attack: Int = 0
    val isAlive: Boolean
        get() = health > 0

    fun damage(damage:Int) { health -= damage }
}