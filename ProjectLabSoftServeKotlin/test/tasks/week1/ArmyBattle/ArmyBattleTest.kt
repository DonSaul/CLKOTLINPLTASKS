package tasks.week1.ArmyBattle

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ArmyBattleTest {

    @Test
    fun `Dwarf must damage Orc`() {
        val dwarf = Dwarfs()
        val orc = Orcs()
        dwarf.damage(12)
        assertTrue(orc.health <= 30)
    }

    @Test
    fun `Orc must damage Dwarf`() {
        val dwarf = Dwarfs()
        val orc = Orcs()
        orc.damage(12)
        assertTrue(dwarf.health <= 30)
    }

    @Test
    fun `Function must return true if army1 (dwarfs) win`() {
        val army1 = Army()
        army1.addUnits(10) { Dwarfs() }

        val army2 = Army()
        army2.addUnits(5) { Orcs() }

        assertTrue(fight(army1, army2))
    }

    @Test
    fun `Fight function must return false if army2 win`() {
        val army1 = Army()
        army1.addUnits(5) { Dwarfs() }

        val army2 = Army()
        army2.addUnits(10) { Orcs() }

        assertFalse(fight(army1, army2))
    }

}
