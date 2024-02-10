package weeks.week01

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.*

class ArmyBattleFightTest {

    @Test
    @DisplayName("Battle 1")
    fun `First army loses against second army in a battle`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) { Knight() }
        army2.addUnits(2) { Warrior() }

        val result = battle(army1, army2)

        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle 2")
    fun `Second army wins when fighting against first army`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Knight() }

        val result = battle(army1, army2)

        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle 3")
    fun `First army wins when fighting against second army with more units`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Warrior() }
        army2.addUnits(3) { Knight() }

        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle 4")
    fun `Second army wins when fighting against first army with more units`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(3) { Warrior() }
        army2.addUnits(5) { Knight() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle 5")
    fun `First army loses in a battle with 20 warriors against 21 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle 6")
    fun `First army loses in a battle with 10 warriors against 11 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle 7")
    fun `First army wins in a battle with 11 warriors against 7 warriors`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle 8")
    fun `First army wins against second army with Defenders`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Warrior() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(4) { Warrior() }

        val result = battle(army1, army2)

        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle 9")
    fun `Both armies have Defenders, but first army wins`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Defender() }
        army1.addUnits(20) { Warrior() }
        army1.addUnits(4) { Defender() }
        army2.addUnits(21) { Warrior() }

        val result = battle(army1, army2)

        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle 10")
    fun `First army loses against second army with mixed Warrior and Defender units`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Warrior() }
        army1.addUnits(1) { Defender() }
        army2.addUnits(5) { Warrior() }

        val result = battle(army1, army2)

        assertEquals(false, result)
    }
    @Test
    @DisplayName("Battle 11")
    fun `First army loses against second army`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Defender() }
        army1.addUnits(6) { Vampire() }
        army1.addUnits(7) { Warrior() }
        army2.addUnits(6) { Warrior() }
        army2.addUnits(6) { Defender() }
        army2.addUnits(6) { Vampire() }

        val result = battle(army1, army2)

        assertEquals(false, result)
    }



    @Test
    @DisplayName("Battle 12")
    fun `First army wins against second army`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(9) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(15) { Warrior() }
        army2.addUnits(4) { Warrior() }
        army2.addUnits(9) { Defender() }
        army2.addUnits(13) { Vampire() }

        val result = battle(army1, army2)

        assertEquals(true, result)
    }
}