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
    val chuck = Warrior();
    val bruce = Warrior();
    val carl = Knight();
    val dave = Warrior();
    val mark = Warrior();
    val bob = Defender();
    val mike = Knight();
    val rog = Warrior();
    val lancelot = Defender();
    val eric = Vampire();
    val adam = Vampire();
    val richard = Defender();
    val ogre = Warrior();
    val freelancer = Lancer();
    val vampire = Vampire();

    check(fight(chuck, bruce) == true);
    check(fight(dave, carl) == false);
    check(chuck.isAlive == true);
    check(bruce.isAlive == false);
    check(carl.isAlive == true);
    check(dave.isAlive == false);
    check(fight(carl, mark) == false);
    check(carl.isAlive == false);
    check(fight(bob, mike) == false);
    check(fight(lancelot, rog) == true);
    check(fight(eric, richard) == false);
    check(fight(ogre, adam) == true);
    check(fight(freelancer, vampire) == true);
    check(freelancer.isAlive == true);

    val myArmy = Army();
    myArmy.addUnits(2) { Defender() };
    myArmy.addUnits(2) { Vampire() };
    myArmy.addUnits(4) { Lancer() };
    myArmy.addUnits(1) { Warrior() };

    val enemyArmy = Army();
    enemyArmy.addUnits(2) { Warrior() };
    enemyArmy.addUnits(2) { Lancer() };
    enemyArmy.addUnits(2) { Defender() };
    enemyArmy.addUnits(3) { Vampire() };

    val army3 = Army();
    army3.addUnits(1) { Warrior() };
    army3.addUnits(1) { Lancer() };
    army3.addUnits(2) { Defender() };

    val army4 = Army();
    army4.addUnits(3) { Vampire() };
    army4.addUnits(1) { Warrior() };
    army4.addUnits(2) { Lancer() };

    check(fight(myArmy, enemyArmy) == true);
    check(fight(army3, army4) == false);
    println("OK")
}
