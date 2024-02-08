package org.softserve.projectlab

/**
 * Simula un duelo entre dos objetos de la clase Warrior.
 * @return true si el primer argumento gana el duelo, false en caso contrario.
 *
 * @param warrior1 objeto de clase Warrior.
 * @param warrior2 objeto de clase Warrior.
 */
fun fight(warrior1: Warrior?,
          warrior2: Warrior?,
          straightFight: Boolean = false): Boolean {
    if (warrior1 == null) {
        return false
    }
    if (warrior2 == null) {
        return true
    }
    while (warrior1.isAlive && warrior2.isAlive) {
        if (straightFight){
            warrior1.attack(warrior2, true)
        } else {
            warrior1.attack(warrior2)
        }
        if (warrior2.isAlive) {
            if (straightFight) {
                warrior2.attack(warrior1, true)
            } else {
                warrior2.attack(warrior1)
            }
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
    var warrior1: Warrior? = army1.getUnit()
    var warrior2: Warrior? = army2.getUnit()

    while (army1.hasFighters() && army2.hasFighters() ) {
        val warrior1Win: Boolean = fight(warrior1, warrior2)
        if (warrior1Win && army2.hasFighters()) {
            warrior2 = army2.getUnit()!!
        } else if (!warrior1Win && army1.hasFighters()){
            warrior1 = army1.getUnit()!!
        }
    }
    return army1.hasFighters()
}

fun straightFight(army1: Army,
                  army2: Army): Boolean {
    while (army1.hasFighters() && army2.hasFighters() ) {
        val warrior1: Warrior? = army1.getUnit()
        val warrior2: Warrior? = army2.getUnit()
        fight(warrior1, warrior2, true)
        for (army in listOf(army1, army2)) {
            if (army.activeFighterIsLast()) {
                for (a in listOf(army1, army2)) {
                    a.cleanCasualties()
                }
                break
            }
        }
    }
    return army1.hasFighters()
}

fun main() {
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
    val freelancer = Lancer()
    val vampire = Vampire()
    val priest = Healer()

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
    check(fight(freelancer, vampire) == true)
    check(freelancer.isAlive == true)
    check(freelancer.health == 14)
    priest.heal(freelancer)
    check(freelancer.health == 16)

    val myArmy = Army().apply {
        addUnits(2) { Defender() }
        addUnits(1) { Healer() }
        addUnits(2) { Vampire() }
        addUnits(2) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(1) { Warrior() }
    }

    val enemyArmy = Army().apply {
        addUnits(2) { Warrior() }
        addUnits(4) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(2) { Defender() }
        addUnits(3) { Vampire() }
        addUnits(1) { Healer() }
    }

    val army3 = Army().apply {
        addUnits(1) { Warrior() }
        addUnits(1) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(2) { Defender() }
    }

    val army4 = Army().apply {
        addUnits(3) { Vampire() }
        addUnits(1) { Warrior() }
        addUnits(1) { Healer() }
        addUnits(2) { Lancer() }
    }

    val army5 = Army().apply {
        addUnits(10) { Warrior() }
    }

    val army6 = Army().apply {
        addUnits(6) { Warrior() }
        addUnits(5) { Lancer() }
    }

    check(fight(myArmy, enemyArmy) == false)
    check(fight(army3, army4) == true)
    check(straightFight(army5, army6) == false)
    println("OK")
}
