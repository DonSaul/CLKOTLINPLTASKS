package org.softserve.projectlab

class Healer(
    health: Int = 60,
    attack: Int = 0
): Warrior(health, attack), IHealer {

    override fun heal(target: Warrior) {
        target.recover(2)
    }

    override fun watchAttack(inflictedDamage: Int, attacker: Warrior) {
        if ((inflictedDamage > 0) && (attacker == frontPartner)) {
            heal(frontPartner!!)
        }
    }
}