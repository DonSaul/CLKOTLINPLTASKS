
/**
 * Simula un duelo entre dos objetos de la clase Warrior.
 * Retorna true si el primer argumento gana el duelo, false en caso contrario.
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
fun main() {
    val warrior1 = Warrior()
    val warrior2 = Knight()
    println(warrior1.isAlive)
    val result = fight(warrior1, warrior2)
    if (result) {
        println("Warrior 1 wins!")
    } else {
        println("Warrior 2 wins!")
    }
    println(warrior1.isAlive)
}