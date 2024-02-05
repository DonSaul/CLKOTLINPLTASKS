package org.softserve.task2.charactercreation

open class Character(
    val name: String,
    protected var healthPoints: Int,
    protected var attackPoints: Int) {

    open fun takeDamage(damage: Int) {
        this.healthPoints -= damage

        if (this.healthPoints <= 0) {
            println("$name fainted")
        } else {
            println("Current health points of $name: $healthPoints")
        }
    }

    open fun attack(target: Character) {
        println("$name is attacking ${target.name} with $attackPoints points of damage")
        target.takeDamage(this.attackPoints)
    }
}

class Wizard(
    name: String,
    healthPoints: Int,
    attackPoints: Int,
    var manaPoints: Int) : Character(name, healthPoints, attackPoints) {

    fun attack(target: Character, mana: Int) {
        val totalDamage: Int

        println("${this.name} is casting a spell over ${target.name} using $mana points of mana.")
        if (this.manaPoints >= mana) {
            totalDamage = this.attackPoints + mana
            this.manaPoints -= mana
            println("Spell successfully casted over ${target.name} with $totalDamage points of damage")
            target.takeDamage(totalDamage)
        } else {
            println("${this.name} doesn't have enough mana")
        }
        println("${this.name} current mana: ${this.manaPoints}")

    }
}

fun main() {
    val warrior = Character("Thrall", 100, 20)
    val wizard = Wizard("Sylvanas", 100, 5, 25)
    println("Warrior name: ${warrior.name}")
    // Warrior name: Thrall
    println("Wizard name: ${wizard.name}")
    // Wizard name: Sylvanas

    wizard.attack(warrior)
    // Sylvanas is attacking Thrall with 5 points of damage
    // Current health points of Thrall: 95
    warrior.attack(wizard)
    // Thrall is attacking Sylvanas with 20 points of damage
    // Current health points of Sylvanas: 80
    wizard.attack(warrior, 10)
    // Sylvanas is casting a spell over Thrall using 10 points of mana.
    // Spell successfully casted over Thrall with 15 points of damage
    // Current health points of Thrall: 80
    // Sylvanas current mana: 15
    warrior.attack(wizard)
    // Thrall is attacking Sylvanas with 20 points of damage
    // Current health points of Sylvanas: 60
    wizard.attack(warrior, 16)
    // Sylvanas is casting a spell over Thrall using 16 points of mana.
    // Sylvanas doesn't have enough mana
    // Sylvanas current mana: 15
}