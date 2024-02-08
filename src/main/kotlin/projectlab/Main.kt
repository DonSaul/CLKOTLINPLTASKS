package org.softserve.projectlab

/**
 * Simula un duelo entre dos objetos de la clase Warrior.
 * @return true si el primer argumento gana el duelo, false en caso contrario.
 *
 * @param warrior1 objeto de clase Warrior.
 * @param warrior2 objeto de clase Warrior.
 */
fun fight(warrior1: Warrior,
          warrior2: Warrior,
          straightFight: Boolean = false): Boolean {
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
    var warrior1: Warrior = army1.getUnit()!!
    var warrior2: Warrior = army2.getUnit()!!

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


fun main() {
    var chuck = Warrior()
    var bruce = Warrior()
    var carl = Knight()
    var dave = Warrior()
    var mark = Warrior()
    var bob = Defender()
    var mike = Knight()
    var rog = Warrior()
    var lancelot = Defender()
    var eric = Vampire()
    var adam = Vampire()
    var richard = Defender()
    var ogre = Warrior()
    var freelancer = Lancer()
    var vampire = Vampire()
    var priest = Healer()

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

    var my_army = Army().apply {
        addUnits(2) { Defender() }
        addUnits(1) { Healer() }
        addUnits(2) { Vampire() }
        addUnits(2) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(1) { Warrior() }
    }

    var enemy_army = Army().apply {
        addUnits(2) { Warrior() }
        addUnits(4) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(2) { Defender() }
        addUnits(3) { Vampire() }
        addUnits(1) { Healer() }
    }
    var army_3 = Army().apply {
        addUnits(1) { Warrior() }
        addUnits(1) { Lancer() }
        addUnits(1) { Healer() }
        addUnits(2) { Defender() }
    }

    var army_4 = Army().apply {
        addUnits(3) { Vampire() }
        addUnits(1) { Warrior() }
        addUnits(1) { Healer() }
        addUnits(2) { Lancer() }
    }

    check(fight(my_army, enemy_army) == false)
    check(fight(army_3, army_4) == true)
    println("OK")
}
