package org.softserve.projectlab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FightTest {

    @Test
    @DisplayName("1. Fight")
    fun `Jon (caballero) debe ganar a Carl (guerrero)`() {
        // given
        val carl = Warrior()
        val jon = Knight()
        // when
        val res = fight(carl, jon)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Ramon (caballero) debe ganar a Slevin (guerrero)`() {
        // given
        val ramon = Knight()
        val slevin = Warrior()
        // when
        val res = fight(ramon, slevin)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("3. Fight")
    fun `Bob primero en golpear debe ganar a Mars`() {
        // given
        val bob = Warrior()
        val mars = Warrior()
        fight(bob, mars)
        // when
        val res = bob.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("4. Fight")
    fun `Zeus (caballero) debe ganar a Godkiller (guerrero)`() {
        // given
        val zeus = Knight()
        val godkiller = Warrior()
        fight(zeus, godkiller)
        // when
        val res = zeus.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Husband (guerrero) debe ganar a Wife (guerrero)`() {
        // given
        val husband = Warrior()
        val wife = Warrior()
        fight(husband, wife)
        // when
        val res = wife.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("6. Fight")
    fun `Knight (caballero) debe ganar a Dragon (guerrero)`() {
        // given
        val dragon = Warrior()
        val knight = Knight()
        fight(dragon, knight)
        // when
        val res = knight.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("7. Fight")
    fun `Pelea triple, unit2 es debilitado por unit1, en su siguiente pelea gana unit3`() {
        // given
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()
        fight(unit1, unit2)
        // when
        val res = fight(unit2, unit3)
        // then
        assertEquals(false, res) {
            "No ganó unit3"
        }

    }

    @Test
    internal fun `When Defender fights against Rookie his health won't increase`() {
        val defender = Defender()
        val initialHealth = defender.health

        fight(defender, Rookie())

        assertEquals(initialHealth, defender.health)
    }
    @Test
    @DisplayName("8. Fight")
    fun `Defender vs Rockie, gana Defender sin afectar su nivel de salud`() {
        // given
        val unit1 = Defender()
        val unit2 = Rookie()
        // when
        fight(unit1, unit2)
        // then
        assertEquals(60, unit1.health ) {
            "El nivel de salud de defender cambió"
        }
    }

    @Test
    @DisplayName("9. Fight")
    fun `Pelea triple, unit1 es debilitado por unit2, en su siguiente pelea gana a unit3`() {
        // given
        val unit1 = Defender()
        val unit2 = Rookie()
        val unit3 = Warrior()
        fight(unit1, unit2)
        // when
        val res = fight(unit1, unit3)
        // then
        assertEquals(true, res) {
            "No ganó unit1"
        }
    }

    @Test
    @DisplayName("1. Battle")
    fun `army1 vs army2, gana army1`(){
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(4) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res) {
            "No ganó army1"
        }
    }

    @Test
    @DisplayName("2. Battle")
    fun `p2 army1 vs army2, gana army1`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army1.addUnits(5) { Defender() }
        army1.addUnits(5) { Warrior() }
        army2.addUnits(10) { Defender() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res) {
            "No ganó army1"
        }
    }

    @Test
    @DisplayName("3. Battle")
    fun `army1 vs army2, gana army2`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Warrior() }
        army1.addUnits(1) { Defender() }
        army2.addUnits(5) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res) {
            "No ganó army2"
        }
    }

}
