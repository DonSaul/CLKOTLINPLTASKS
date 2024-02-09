package org.softserve.projectlab
/**
 * Clase Army que representa un ejército con objetos de la clase Warrior en sus filas, listos para la batalla.
 *
 * @property armyQueue Fila vacia que contentrá objetos de la clase Warrior.
 * @property armyIterator Iterador que recorre cada elemento de la fila
 *
 */
class Army(): IEnlister {
    val armyQueue: ArrayDeque<Warrior> = ArrayDeque()
    private var armyIterator: Iterator<Warrior> = armyQueue.iterator()
    var activeFighter: Warrior? = null
    /**
     * Agrega unidades al ejército.
     *
     * @param cantidad La cantidad de unidades a crear.
     * @param unitCreator Una lambda que inicializa y retorna un objeto de la clase Warrior.
     */

    fun addUnits(cantidad: Int, unitCreator: () -> Warrior ) {
        repeat(cantidad) {
            val unit: Warrior = unitCreator()
            enlist(unit)
            this.armyQueue.addLast(unit)
            communicateWarriorsStatus()
        }
    }
    fun getUnit(): Warrior? {
        activeFighter?.run {
            while (armyQueue.indexOf(activeFighter) < armyQueue.size) {
                if (activeFighter!!.isAlive){
                    return activeFighter
                }
                nextUnit()
            }
        } ?: run{
            if (hasFighters()) {
                return nextUnit()
            }
        }
        return null
    }

    /**
     * Comprueba si el ejército tiene guerreros vivos.
     *
     * @return true si el ejército tiene al menos un guerrero vivo, false de lo contrario.
     */
    fun hasFighters(): Boolean {
        return armyQueue.any { it.isAlive }
    }
    /**
     * Obtiene al siguiente guerrero en la fila del ejército.
     *
     * @return El siguiente guerrero vivo en la fila del ejército.
     */
    private fun nextUnit(): Warrior? {
        communicateWarriorsStatus()
        if (armyIterator.hasNext()){
            activeFighter = armyIterator.next()
            while (!activeFighter!!.isAlive) {
                activeFighter = armyIterator.next()
            }
            return activeFighter
        }
        return null
    }

    fun restoreIterator() {
        armyIterator = armyQueue.iterator()
    }

    fun cleanCasualties() {
        val armyQueue = armyQueue.filter { it.isAlive }
//        println("$this Remaining units: ${armyQueue.size}")
        restoreIterator()
        communicateWarriorsStatus()
    }

    override fun enlist(warrior: Warrior) {
        warrior.updateMyArmy(this)
    }
    override fun communicateWarriorsStatus() {
        for (warrior in armyQueue){
            warrior.updatePreviousPartner()
            warrior.updateFrontPartner()
        }
    }
    fun activeFighterIsLast(): Boolean{
        return activeFighter == armyQueue.last()
    }
}