package weeks.week01
import java.util.Stack

class Army {
    private val units = Stack<Warrior>()
    private var survivingUnit: Warrior? = null

    fun getUnits(): Stack<Warrior> {
        return units
    }

    fun addUnits(count: Int, warriorFactory: () -> Warrior) {
        repeat(count) {
            units.push(warriorFactory.invoke())
        }
    }

    fun hasUnits(): Boolean {
        return units.isNotEmpty() || survivingUnit != null
    }

    fun getNextUnit(): Warrior? {
        if (survivingUnit != null) {
            val unit = survivingUnit
            survivingUnit = null
            return unit
        }
        return if (hasUnits()) units.pop() else null
    }

    fun setSurvivingUnit(warrior: Warrior?) {
        survivingUnit = warrior
    }
}

fun getUnitBehind(army: Stack<Warrior>): Warrior? {
    val tempStack = Stack<Warrior>()

    while (!army.isEmpty()) {
        val unit = army.pop()
        return unit
    }
    return null
}

fun battle(army1: Army, army2: Army): Boolean {
    var fighter1: Warrior?
    var fighter2: Warrior?
    do {
        fighter1 = army1.getNextUnit()
        fighter2 = army2.getNextUnit()



        if (fighter1 != null && fighter2 != null) {

            val warrior1Survived = fight(fighter1, fighter2)
            if (fighter1 is Lancer) {
                val unitBehindDefender = getUnitBehind(army2.getUnits())
                if (unitBehindDefender != null) {
                    val damage = fighter1.attack * 0.5
                    unitBehindDefender.receiveDamage(damage)
                }
            }

            if (warrior1Survived) {
                army2.setSurvivingUnit(null)
            } else {
                army1.setSurvivingUnit(null)
            }
        }
    } while (army1.hasUnits() && army2.hasUnits())

    return army1.hasUnits()
}

fun main() {
    val myArmy = Army()
    myArmy.addUnits(2) { Defender() }
    myArmy.addUnits(2) { Vampire() }
    myArmy.addUnits(4) { Lancer() }
    myArmy.addUnits(1) { Warrior() }

    val enemyArmy = Army()
    enemyArmy.addUnits(2) { Warrior() }
    enemyArmy.addUnits(2) { Lancer() }
    enemyArmy.addUnits(2) { Defender() }
    enemyArmy.addUnits(3) { Vampire() }

    val army3 = Army();
    army3.addUnits(1) { Warrior() };
    army3.addUnits(1) { Lancer() };
    army3.addUnits(2) { Defender() };

    val army4 = Army();
    army4.addUnits(3) { Vampire() };
    army4.addUnits(1) { Warrior() };
    army4.addUnits(2) { Lancer() };

    val result = battle(myArmy, enemyArmy)
    val result2 = battle(army3, army4)

    println("Result: ${if (result) "Army1 wins!" else "Army2 wins!"}")
    println("Result: ${if (result2) "Army3 wins!" else "Army4 wins!"}")
}
