package org.softserve.projectlab

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
        warrior1.attack(warrior2)
        if (warrior2.isAlive) {
            warrior2.attack(warrior1)
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
          army2: Army): Boolean {
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
    // smoke test
    val chuck = Warrior()
    val bruce = Warrior()
    val carl = Knight()
    val dave = Warrior()
    val mark = Warrior()
    val bob = Defender()
    val mike = Knight()
    val rog = Warrior()
    val lancelot = Defender()
    val eric = Vampire()
    val adam = Vampire()
    val richard = Defender()
    val ogre = Warrior()

    check(fight(chuck, bruce) == true)
    check(fight(dave, carl) == false)
    check(chuck.isAlive == true)
    check(bruce.isAlive == false)
    check(carl.isAlive == true)
    check(dave.isAlive == false)
    check(fight(carl, mark) == false)
    check(carl.isAlive == false)
    check(fight(bob, mike) == false)
    check(fight(lancelot, rog) == true)
    check(fight(eric, richard) == false)
    check(fight(ogre, adam) == true)

    val myArmy = Army().apply {
        addUnits(2) { Defender() }
        addUnits(2) { Vampire() }
        addUnits(1) { Warrior() }
    }

    val enemyArmy = Army().apply {
        addUnits(2) { Warrior() }
        addUnits(2) { Defender() }
        addUnits(3) { Vampire() }
    }

    val army3 = Army().apply {
        addUnits(1) { Warrior() }
        addUnits(4) { Defender() }
    }

    val army4 = Army().apply {
        addUnits(3) { Vampire() }
        addUnits(2) { Warrior() }
    }

    check(fight(myArmy, enemyArmy) == false)
    check(fight(army3, army4) == true)
    println("OK")
}
