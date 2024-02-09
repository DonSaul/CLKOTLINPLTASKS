package tasks.week1.ArmyBattle

import org.example.tasks.week1.ArmyBattle.*
import org.junit.jupiter.api.Assertions.*
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

    @Test
    fun `Carl must lose against Jim (Dwarf)`() {
        val carl = Army()
        carl.addUnits(1) { Orcs() }
        val jim = Army()
        jim.addUnits(1) { Dwarfs() }
        assertFalse(fight(carl, jim))
    }

    @Test
    fun `ramon(Dwarf) must win against slevin(Orc)`() {
        val ramon = Army()
        ramon.addUnits(1) { Dwarfs() }
        val slevin = Army()
        slevin.addUnits(1) { Orcs() }
        assertTrue(fight(ramon, slevin))
    }

    @Test
    fun `bob(dwarf) against mars(dwarf)`() {
        val bob = Army()
        bob.addUnits(1) { Dwarfs() }
        val mars = Army()
        mars.addUnits(1) { Dwarfs() }
        assertTrue(fight(bob, mars))
    }


    @Test
    fun `Zeus(Orc) against goodKiller(Dwarf) wins goodKiller`() {
        val zeus = Army()
        zeus.addUnits(1) { Orcs() }
        val goodKiller = Army()
        goodKiller.addUnits(1) { Dwarfs() }
        assertFalse(fight(zeus, goodKiller))
    }

    @Test
    fun `husband(Dwarf) against wife(Dwarf), wife's win`() {
        val husband = Army()
        husband.addUnits(1) { Dwarfs() }
        val wife = Army()
        wife.addUnits(1) { Dwarfs() }
        assertTrue(fight(husband, wife))
    }

    @Test
    fun `dragon(Dwarf) against knight(orc)`() {
        val dragon = Army()
        dragon.addUnits(1) { Dwarfs() }
        val knights = Army()
        knights.addUnits(1) { Orcs() }
        assertTrue(fight(dragon, knights))
    }


    @Test
    fun `Unit1(Dwarf) against unit2(Orc) against unit3(dwarf)`() {
        val unit1 = Army()
        unit1.addUnits(1) { Dwarfs() }
        val unit2 = Army()
        unit2.addUnits(1) { Orcs() }
        val unit3 = Army()
        unit3.addUnits(1) { Dwarfs() }

        fight(unit1, unit2)
        assertFalse(fight(unit2, unit3))
    }

    @Test
    fun `Unit1(Defender) against Unit2(Rockie) after fight unit1 health should be 60 `() {
        val unit1 = Army()
        unit1.addUnits(1) { Defender() }
        val unit2 = Army()
        unit2.addUnits(1) { Rockie() }
        fight(unit1, unit2)

        val unit1AfterFight = unit1.firstSurvivedUnit()?.health
        assertEquals(41, unit1AfterFight)
    }

    @Test
    fun `unit 1 should win to unit3 after fight uni2 `() {
        val unit1 = Army()
        unit1.addUnits(1) { Defender() }
        val unit2 = Army()
        unit2.addUnits(1) { Rockie() }
        val unit3 = Army()
        unit3.addUnits(1) { Dwarfs() }
        fight(unit1, unit2)
        assertTrue(fight(unit1, unit3))
    }

    @Test
    fun `army1 should be destroyed by army2`() {
        val army1 = Army()
        army1.addUnits(1) { Orcs() }
        val army2 = Army()
        army2.addUnits(2) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }


    @Test
    fun `Army 1 should win 10 army dwarfs `() {
        val army1 = Army()
        army1.addUnits(10) { Dwarfs() }
        val army2 = Army()
        army2.addUnits(11) { Dwarfs() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `Army 1 should win 11 army dwarfs `() {
        val army1 = Army()
        army1.addUnits(11) { Dwarfs() }
        val army2 = Army()
        army2.addUnits(7) { Dwarfs() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `Army 1 should win 11 changing units`() {
        val army1 = Army()
        army1.addUnits(5) { Dwarfs() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        val army2 = Army()
        army2.addUnits(4) { Dwarfs() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `Army 1 should win after change units and fight against army 2`() {
        val army1 = Army()
        army1.addUnits(5) { Defender() }
        army1.addUnits(20) { Dwarfs() }
        val army2 = Army()
        army2.addUnits(21) { Dwarfs() }
        army1.addUnits(4) { Defender() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `Army1 should win after change trooper and fight`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Dwarfs() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(5) { Dwarfs() }
        army1.addUnits(10) { Defender() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `army1 should be defeated against army2`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Dwarfs() }
        army1.addUnits(1) { Defender() }
        army2.addUnits(50) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `11army 1 should be defeated by army2`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Defender() }
        army1.addUnits(6) { Vampire() }
        army1.addUnits(7) { Dwarfs() }

        army2.addUnits(6) { Dwarfs() }
        army2.addUnits(6) { Defender() }
        army2.addUnits(6) { Vampire() }
        assertFalse(fight(army1, army2))
    }


    @Test
    fun `12 army1 should be defeated army2`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(2) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Dwarfs() }

        army2.addUnits(4) { Dwarfs() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(3) { Vampire() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `13Army 1 should win army2`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(11) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Dwarfs() }

        army2.addUnits(4) { Dwarfs() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(13) { Vampire() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `army1 should win army2`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(9) {Defender()}
        army1.addUnits(3) {Vampire()}
        army1.addUnits(8) {Dwarfs()}

        army2.addUnits(4) {Dwarfs()}
        army2.addUnits(4) {Defender()}
        army2.addUnits(13) {Vampire()}
        assertTrue(fight(army1, army2))
    }
}
