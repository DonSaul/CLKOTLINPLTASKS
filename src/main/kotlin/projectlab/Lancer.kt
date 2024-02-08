package org.softserve.projectlab


/**
 * Clase Lancer.
 * Capaz de inflingir daño al enemigo posterior.
 *
 * @property health Salud total del lancero. Por defecto, se establece en 50.
 * @property attack Daño infligido en cada ataque. Por defecto, se establece en 6.
 * @property isAlive Devuelve true si el lancero está vivo (su salud es mayor que 0), false de lo contrario.
 *
 * @constructor Crea un nuevo guerrero con la salud y el ataque especificados (o los valores predeterminados si no se proporcionan).
 * @param health La salud inicial del guerrero.
 * @param attack El daño infligido en cada ataque.
 */
class Lancer(
    health: Int = 50,
    attack: Int = 6
): Warrior(health, attack) {

    override fun attack(target: Warrior, straightFight: Boolean) {
        val totalDamage = target.takeDamage(attack)
        if (!straightFight) {
            attackNext(getNextEnemy(target), totalDamage)
        }
    }

    /**
     * Attacks the warrior that is after his current rival with half of the total damage inflicted to the rival.
     */
    private fun attackNext(target: Warrior?, totalDamage: Int) {
        val halfDamage: Int = (totalDamage * 0.5).toInt()
        target?.takeDamage(halfDamage)
    }

    /**
     * Identifies the current rival's army
     */
    private fun detectArmy(target: Warrior): Army? {
        return target.myArmy
    }

    /**
     * @return the warrior that is after his current rival.
     */

    private fun getNextEnemy(target: Warrior): Warrior? {
        val army: Army? = detectArmy(target)
        if (army != null) {
            var index = army.armyQueue.indexOf(target) + 1
            while (index < army.armyQueue.size) {
                val nextEnemy: Warrior = army.armyQueue[index]
                if (nextEnemy.isAlive) {
                    return nextEnemy
                }
                index++
            }
        }
        return null
    }

}