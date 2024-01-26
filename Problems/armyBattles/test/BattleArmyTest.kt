import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class BattleArmyTest {

    @Test
    @DisplayName("1. Battle")
    fun `Army2 debe ganar a Army1`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Battle")
    fun `Army2 debe ganar a Army1 p2`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Warrior() }
        army2.addUnits(3) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Battle")
    fun `Army2 debe ganar a Army1 p3`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army2.addUnits(7) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("4. Battle")
    fun `Army1 debe ganar a Army2`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Battle")
    fun `Army1 debe ganar a Army2 p2`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("6. Battle")
    fun `Army1 debe ganar a Army2 p3`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

}