package org.softserve.projectlab

interface IEnlister {
    fun enlist(warrior: Warrior)
    fun communicateWarriorsStatus()
}

interface IEnlisted {
    var myArmy: Army?
    var previousPartner: Warrior?
    var frontPartner: Warrior?
    fun updateMyArmy(army: Army)
    fun updatePreviousPartner()
    fun updateFrontPartner()
    fun showAttack(inflictedDamage: Int)
    fun watchAttack(inflictedDamage: Int, attacker: Warrior)
}

interface IHealer {
    fun heal(target: Warrior)
}