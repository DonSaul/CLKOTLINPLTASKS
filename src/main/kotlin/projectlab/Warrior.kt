package org.softserve.projectlab

/**
 * Clase Warrior.
 *
 * @property health Salud total del guerrero. Por defecto, se establece en 50.
 * @property attack Daño infligido en cada ataque. Por defecto, se establece en 5.
 * @property isAlive Devuelve true si el guerrero está vivo (su salud es mayor que 0), false de lo contrario.
 *
 * @constructor Crea un nuevo guerrero con la salud y el ataque especificados (o los valores predeterminados si no se proporcionan).
 * @param health La salud inicial del guerrero.
 * @param attack El daño infligido en cada ataque.
 */
open class Warrior(
    open var health: Int = 50,
    open val attack: Int = 5,
): IEnlisted {
    override var myArmy: Army? = null
    override var previousPartner: Warrior? = null
    override var frontPartner : Warrior? = null
    var currentEnemy: Warrior? = null
    private val maxHealth: Int = health

    /**
     * @return true si el guerrero está vivo (su salud es mayor que 0), false de lo contrario.
     */
    val isAlive: Boolean
        get() = health > 0
    open fun takeDamage(damage: Int): Int {
        health -= damage
        return damage
    }

    fun recover(recoverPoints: Int) {
        health += recoverPoints
        if (health > maxHealth) {
            health = maxHealth
        }
    }
    open fun attack(target: Warrior, straightFight: Boolean = false) {
        currentEnemy = target
        val inflictedDamage = target.takeDamage(attack)
        if (!straightFight){
            showAttack(inflictedDamage)
        }
    }

    override fun updateMyArmy(army: Army) {
        myArmy = army
    }

    override fun updatePreviousPartner() {
        if ((previousPartner == null) && (myArmy!!.armyQueue[0] != this)) {
            previousPartner = myArmy!!.armyQueue[myArmy!!.armyQueue.indexOf(this) - 1]
        }
    }
    override fun updateFrontPartner() {
        if (((frontPartner == null ) || (!frontPartner!!.isAlive)) && (myArmy!!.armyQueue.last() != this)){
            frontPartner = myArmy!!.armyQueue[myArmy!!.armyQueue.indexOf(this) + 1]
        }
    }

    override fun showAttack(inflictedDamage: Int) {
        if (inflictedDamage > 0) {
            previousPartner?.watchAttack(inflictedDamage, this)
            frontPartner?.watchAttack(inflictedDamage, this)
        }
    }

    override fun watchAttack(inflictedDamage: Int, attacker: Warrior) {}

}