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
    var health: Int = 50,
    var attack: Int = 5
) {
    /**
     * Devuelve true si el guerrero está vivo (su salud es mayor que 0), false de lo contrario.
     */
    val isAlive: Boolean
        get() = health > 0
}