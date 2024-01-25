/**
 * Simula un duelo entre dos objetos de la clase Warrior.
 * @return true si el primer argumento gana el duelo, false en caso contrario.
 *
 * @param warrior1 objeto de clase Warrior.
 * @param warrior2 objeto de clase Warrior.
 */
fun fight(warrior1: Warrior,
          warrior2: Warrior): Boolean {
    while (warrior1.isAlive && warrior2.isAlive) {
        warrior2.health -= warrior1.attack
        if (warrior2.isAlive) {
            warrior1.health -= warrior2.attack
        }
    }
    return warrior1.isAlive
}

/**
 * Simula un combate entre dos ejercitos.
 *
 * Se obtiene el primer objeto de la clase Warrior de cada Army.
 *
 * El loop se ejecutará siempre y cuando ambas Army tengan Warriors vivos para luchar,
 * en cada ciclo hay un duelo entre el Warrior de turno de cada Army,
 * si un Warrior es derrotado se obtiene el siguiente de su Army para continuar la lucha.
 *
 * @param army1 Ejército que combatirá
 * @param army2 Ejército que combatirá
 * @return true si el army1 es el ganador y false si pierde
 *
 */
fun fight(army1: Army,
          army2: Army): Any {
    var warrior1: Warrior = army1.nextFighter()
    var warrior2: Warrior = army2.nextFighter()

    while (army1.hasFighters() && army2.hasFighters() ) {
        val warrior1Win: Boolean = fight(warrior1, warrior2)
        if (warrior1Win && army2.hasFighters()) {
            warrior2 = army2.nextFighter()
        } else if (!warrior1Win && army1.hasFighters()){
            warrior1 = army1.nextFighter()
        }
    }
    return army1.hasFighters()
}

fun main() {
    val myArmy = Army()
    myArmy.addUnits(2) { Warrior() }

    val enemyArmy = Army()
    enemyArmy.addUnits(3) { Warrior() }

    val army3 = Army()
    army3.addUnits(20) { Warrior() }
    army3.addUnits(5) { Knight() }

    val army4 = Army()
    army4.addUnits(30) { Warrior() }
    check(fight(myArmy, enemyArmy) == true)
    check(fight(army3, army4) == false)
    println("OK")

}