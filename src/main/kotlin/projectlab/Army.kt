package org.softserve.projectlab
/**
 * Clase Army que representa un ejército con objetos de la clase Warrior en sus filas, listos para la batalla.
 *
 * @property armyQueue Fila vacia que contentrá objetos de la clase Warrior.
 * @property armyIterator Iterador que recorre cada elemento de la fila
 *
 */
class Army() {
    private val armyQueue: ArrayDeque<Warrior> = ArrayDeque()
    private val armyIterator: Iterator<Warrior> = armyQueue.iterator()

    /**
     * Agrega unidades al ejército.
     *
     * @param cantidad La cantidad de unidades a crear.
     * @param unitCreator Una lambda que inicializa y retorna un objeto de la clase Warrior.
     */
    fun addUnits(cantidad: Int, unitCreator: () -> Warrior ) {
        repeat(cantidad) {
            val unit: Warrior = unitCreator()
            this.armyQueue.addLast(unit)
        }
    }

    /**
     * Comprueba si el ejército tiene guerreros vivos.
     *
     * @return true si el ejército tiene al menos un guerrero vivo, false de lo contrario.
     */
    fun hasFighters(): Boolean {
        for (fighter in armyQueue) {
            if (fighter.isAlive) {
                return true
            }
        }
        return false
    }
    /**
     * Obtiene al siguiente guerrero en la fila del ejército.
     *
     * @return El siguiente guerrero vivo en la fila del ejército.
     */
    fun nextFighter(): Warrior {
        return armyIterator.next()
    }
}