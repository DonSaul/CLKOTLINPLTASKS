package org.softserve.projectlab

class Defender(
    health: Int = 60,
    attack: Int = 3,
    private var defense: Int = 2
): Warrior(health, attack) {
    override fun makeDamage(damage: Int) {
        val totalDamage = damage - defense
        if (totalDamage > 0) {
            health -= totalDamage
        }
    }
}