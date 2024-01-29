package weeks.week01

import Warrior
import Knight

class Army {
    val fighters = mutableListOf<Warrior>()

    fun addUnits(count: Int, warriorFactory:()->Warrior) {
        repeat(count) {
            fighters.add(warriorFactory.invoke())
        }
    }
}

fun fightArmy(army1: Army, army2: Army): Boolean {
    var index1 = 0
    var index2 = 0

    while (index1 < army1.fighters.size && index2 < army2.fighters.size) {
        val warrior1 = army1.fighters[index1]
        val warrior2 = army2.fighters[index2]

        while (warrior1.isAlive && warrior2.isAlive) {
            warrior2.receiveDamage(warrior1.attack)
            if (warrior2.isAlive) {
                warrior1.receiveDamage(warrior2.attack)
            }
        }

        if (warrior1.isAlive) {
            index2++
        } else {
            index1++
        }
    }

    return index2 == army2.fighters.size
}

fun main() {
    val army1 = Army()
    army1.addUnits(3) { Knight() }

    val army2 = Army()
    army2.addUnits(3) { Warrior() }

    val army3 = Army()
    army3.addUnits(20) { Warrior() }
    army3.addUnits(5) { Knight() }

    val army4 = Army()
    army4.addUnits(30) { Warrior() }

    val result1 = fightArmy(army1, army4)
    val result2 = fightArmy(army3, army4)

    println("Result 1: Army1 vs. Army2 - ${if (result1) "Army1 wins!" else "Army2 wins!"}")
    println("Result 2: Army3 vs. Army4 - ${if (result2) "Army3 wins!" else "Army4 wins!"}")

}