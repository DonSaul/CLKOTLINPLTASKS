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
}
