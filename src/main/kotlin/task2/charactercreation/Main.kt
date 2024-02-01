package org.softserve.task2.charactercreation

open class Character(
    val name: String,
    protected var healthPoints: Int,
    protected var attackPoints: Int) {

    open fun takeDamage(damage: Int) {
        this.healthPoints -= damage

        if (this.healthPoints <= 0) {
            println("${this.name} fainted")
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
            target.takeDamage(totalDamage)
            this.manaPoints -= mana
            println("Spell successfully casted over ${target.name} with $totalDamage points of damage")
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
    println("Wizard name: ${wizard.name}")

    wizard.attack(warrior)
    warrior.attack(wizard)
    wizard.attack(warrior, 10)
    warrior.attack(wizard)
    wizard.attack(warrior, 16)
}