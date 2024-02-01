package org.softserve.projectlab

/**
 * Clase Knight, más fuerte que Warrior.
 *
 * Extiende de la clase Warrior
 *
 * @property health Salud total del caballero.
 * @property attack Daño inflingido en cada ataque.
 *
 * @constructor Crea un nuevo caballero con la salud y el ataque especificados (o los valores predeterminados si no se proporcionan).
 * @param health La salud inicial del caballero.
 * @param attack El daño infligido en cada ataque.
 */
class Knight(
    health: Int = 50,
    attack: Int = 7
) : Warrior(health, attack)