package weeks.week01

import Warrior
import Knight

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArmyBattleFightTest {

    @Test
    fun `First army loses against second army in a battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) {Knight()}
        army2.addUnits(2) {Warrior()}

        val result = fightArmy(army1, army2)

        assertEquals(false, result)
    }

    @Test
    fun `Second army wins when fighting against first army`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Knight() }

        val result = fightArmy(army1, army2)

        assertEquals(false, result)
    }

    @Test
    fun `First army wins when fighting against second army with more units`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Warrior() }
        army2.addUnits(3) { Knight() }

        val result = fightArmy(army1, army2)
        assertEquals(true, result)
    }

    @Test
    fun `Second army wins when fighting against first army with more units`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(3) { Warrior() }
        army2.addUnits(5) { Knight() }

        val result = fightArmy(army1, army2)
        assertEquals(false, result)
    }

    @Test
    fun `First army wins in a battle with 20 warriors against 21 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }

        val result = fightArmy(army1, army2)
        assertEquals(true, result)
    }

    @Test
    fun `First army wins in a battle with 10 warriors against 11 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }

        val result = fightArmy(army1, army2)
        assertEquals(true, result)
    }

    @Test
    fun `First army wins in a battle with 11 warriors against 7 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }

        val result = fightArmy(army1, army2)
        assertEquals(true, result)
    }
}