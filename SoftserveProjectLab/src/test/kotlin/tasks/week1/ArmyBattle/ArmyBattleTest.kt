package tasks.week1.ArmyBattle

import org.example.tasks.week1.ArmyBattle.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArmyBattleTest {

    @Test
    fun `1-Carl(Dwarf-Warrior) must be defeated against jim(Orc-Knight)`() {
        val carl = Army()
        val jim = Army()

        carl.addUnits(1) { Dwarfs() }
        jim.addUnits(1) { Orcs() }

        assertFalse(fight(carl, jim))
    }

    @Test
    fun `2-Ramon(Orc-Knight) must win against Slevin(Dwarf-Warrior)`() {
        val ramon = Army()
        val slevin = Army()

        ramon.addUnits(1) { Orcs() }
        slevin.addUnits(1) { Dwarfs() }

        assertTrue(fight(ramon, slevin))
    }


    @Test
    fun `3-Bob(Dwarf-Warrior) still is alive before fight against Mars(Dwarf-Warrior) `() {
        val bob = Army()
        val mars = Army()

        bob.addUnits(2) { Dwarfs() }
        mars.addUnits(1) { Dwarfs() }

        val bobIsAlive = fight(bob, mars)
        assertTrue(bobIsAlive)

    }

    @Test
    fun `4-Zeus(Orc-Knight) survive when fight against GodKiller(Dwarf-Warrior)`() {
        val zeus = Army()
        val godKiller = Army()
        zeus.addUnits(1) { Orcs() }
        godKiller.addUnits(1) { Dwarfs() }
        val zeusSurvive = fight(zeus, godKiller)
        assertTrue(zeusSurvive)
    }

    //    "5. Fight": [
//    prepare_test(middle_code='''husband = Warrior()
//    wife = Warrior()
//    fight(husband, wife)''',
//    test="wife.is_alive",
//    answer=False)
//    ],
    @Test
    fun `5-Wife(Dwarf-Warrior) is defeated against Husband(Dwarf-Warrior)`() {
        val husband = Army()
        val wife = Army()
        husband.addUnits(1) { Dwarfs() }
        wife.addUnits(1) { Dwarfs() }

        assertTrue(fight(husband, wife))
    }

    @Test
    fun `6-Dragon(Dwarf-Warrior) fight against Knight(Orc-Knight) and knight win the fight`() {
        val dragon = Army()
        val knight = Army()
        dragon.addUnits(1) { Dwarfs() }
        knight.addUnits(1) { Orcs() }
        val knightWins = fight(dragon, knight)
        assertFalse(knightWins)
    }


    @Test
    fun `7-Unit2(Orc-Knight) die before fight against Unit3(Dwarf-Warrior) but first fight against Unit1(Dwarf-Warrior)`() {
        val unit1 = Army()
        val unit2 = Army()
        val unit3 = Army()

        unit1.addUnits(1) { Dwarfs() }
        unit2.addUnits(1) { Orcs() }
        unit3.addUnits(1) { Dwarfs() }
        fight(unit1, unit2)

        assertFalse(fight(unit2, unit3))
    }


    @Test
    fun `8-Unit1(Defender) remains with a life percentage of 60 when fight against Unit2(Rockie)`() {
        val unit1 = Army()
        val unit2 = Army()
        unit1.addUnits(1) { Defender() }
        unit2.addUnits(1) { Rockie() }
        fight(unit1, unit2)
        val survivedUnit = unit1.firstSurvivedUnit()
        assertEquals(60, survivedUnit?.health)
    }

    @Test
    fun `9-Unit1(Defender) wins when fight against Unit3(Dwarf-Warrior) but first Unit1 fight against Unit2(Rockie)`() {
        val unit1 = Army()
        val unit2 = Army()
        val unit3 = Army()

        unit1.addUnits(1) { Defender() }
        unit2.addUnits(1) { Rockie() }
        unit3.addUnits(1) { Dwarfs() }
        fight(unit1, unit2)
        assertTrue(fight(unit1, unit3))
    }


    //    BATTLES


    @Test
    fun `1-Army1(Dwarf-Warrior,1) is defeated before fight against Army2(Dwarf-Warrior,2)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(1) { Dwarfs() }
        army2.addUnits(2) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `2-Army1(Dwarf-Warrior,2) is defeated before fight against Army2(Dwarf-Warrior,3)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(2) { Dwarfs() }
        army2.addUnits(3) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `3-Army1(Dwarf-Warrior,5) is defeated before fight against Army2(Dwarf-Warrior,7)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Dwarfs() }
        army2.addUnits(7) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }


    @Test
    fun `4-Army1(Dwarf-Warrior,20) is defeated before fight against Army2(Dwarf-Warrior,21)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(20) { Dwarfs() }
        army2.addUnits(21) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `5-Army1(Dwarf-Warrior, 10) defeat Army2(Dwarf-Warrior, 11)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(10) { Dwarfs() }
        army2.addUnits(11) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `6-Army1(Dwarf-Warrior, 11) defeat Army2(Dwarf-Warrior, 7)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(11) { Dwarfs() }
        army2.addUnits(7) { Dwarfs() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `7-Army1(Dwarf-Warrior, 5 && Defender, 9) defeat Army2(Dwarf-Warrior, 4)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Dwarfs() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(7) { Dwarfs() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `8-Army1(Defender, 9 - Dwarf-Warrior, 20) defeat Army2(Dwarf-Warrior, 21)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Defender() }
        army1.addUnits(20) { Dwarfs() }
        army2.addUnits(21) { Dwarfs() }
        army1.addUnits(4) { Defender() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `9-Army1(Dwarf-Warrior, 10 - Defender, 15) Defeat Army2(Dwarf-Warrior, 5)`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Dwarfs() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(5) { Dwarfs() }
        army1.addUnits(10) { Defender() }
        assertTrue(fight(army1, army2))
    }


    @Test
    fun `10-Army1(Defender, 3 - Dwarf-Warrior, 1) is defeated against Army2(Dwarf-Warrior, 5)`() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Dwarfs() }
        army1.addUnits(1) { Defender() }

        army2.addUnits(5) { Dwarfs() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `11-Army1(Defender, 5 - Vampire, 6 - Dwarf-Warrior, 7) is defeated against Army2(Dwarf-Warrior, 6 - Defender, 6 - Vampire, 6)`() {
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
    fun `12-Army1(Defender, 2 - Vampire, 3 - Dwarf-Warrior, 4) is defeated against Army2(Dwarf-Warrior, 4 - Defender, 4 - Vampire, 3)`() {
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
    fun `13-Army1(Defender, 11 - Vampire, 3 - Dwarf-Warrior, 4) defeat Army2(Dwarf-Warrior, 4 - Defender, 4 - Vampire, 13)`() {
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
    fun `14-Army(Defender, 9 - Vampire, 3 - Dwarf-Warrior, 8) Defeat Army2(Dwarf-Warrior, 4 - Defender, 4 - Vampire, 13)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(9) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(8) { Dwarfs() }

        army2.addUnits(4) { Dwarfs() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(13) { Vampire() }
        assertTrue(fight(army1, army2))
    }

    @Test
    fun `15-Army1(Lancer, 5 - Vampire, 3 - Dwarf-Warrior, 4, Defender, 2) is defeated against Army2(Dwarf-Warrior, 4 - Defender, 4 - Vampire, 6 - Lancer, 5)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(5) { Lancer() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Dwarfs() }
        army1.addUnits(2) { Defender() }

        army2.addUnits(4) { Dwarfs() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(6) { Vampire() }
        army2.addUnits(5) { Lancer() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `16-Army1(Lancer, 7 - Vampire, 3 - Dwarf-Warrior, 4 - Defender, 2) Defeat Army2(Dwarf-Warrior, 4 - Defender, 4 - Vampire, 6 - Lancer, 4)`() {
        val army1 = Army()
        val army2 = Army()

        army1.addUnits(7) { Lancer() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Dwarfs() }
        army1.addUnits(2) { Defender() }

        army2.addUnits(4) { Dwarfs() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(6) { Vampire() }
        army2.addUnits(4) { Lancer() }
        assertFalse(fight(army1, army2))
    }

    @Test
    fun `17-ArmyWarrior(Dwarf-Warrior, 2) is defeated against ArmyLancer(Lancer, 1 - Dwarf-Warrior,1)`() {
        val armyWarrior = Army()
        val armyLancer = Army()

        armyWarrior.addUnits(2) { Dwarfs() }

        armyLancer.addUnits(1) { Lancer() }
        armyLancer.addUnits(1) { Dwarfs() }
        assertFalse(fight(armyWarrior, armyLancer))
    }

    
    @Test
    fun `Army1(Lancer, 1 - Dwarf, 3 - Healer, 1 - Dwarf, 4 - Healer, 1 - Orc, 2) should be defeated against Army2(Dwarf, 4 - Defender, 4 - Healer, 1 - Vampire, 6 - Lancer, 4)`() {
        val army1 = Army()
        val army2 = Army()

    army1.addUnits(1) {Lancer()}
    army1.addUnits(3) {Dwarfs()}
    army1.addUnits(1) {Healer()}
    army1.addUnits(4) {Dwarfs()}
    army1.addUnits(1) {Healer()}
    army1.addUnits(2) {Orcs()}

    army2.addUnits(4) {Dwarfs()}
    army2.addUnits(4) {Defender()}
    army2.addUnits(1) {Healer()}
    army2.addUnits(6) {Vampire()}
    army2.addUnits(4) {Lancer()}

    assertFalse(fight(army1, army2))
    }
}
