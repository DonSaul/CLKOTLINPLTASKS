package org.softserve.projectlab

class Vampire(
    health: Int = 40,
    attack: Int = 4,
    val vampirism : Int = 50): Warrior(health, attack) {

    override fun attack(target: Warrior) {
        val totalDamage = target.takeDamage(attack)
        vampirism(totalDamage)
    }

    private fun vampirism(inflictedDamage: Int) {
        val totalRestore = if (inflictedDamage > 0) {
            (inflictedDamage * vampirism) / 100
        } else {
            0
        }
        health += totalRestore
        if (health > 40) {
            health = 40
        }

    }
}