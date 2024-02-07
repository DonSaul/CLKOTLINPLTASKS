package org.softserve.projectlab

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
    fun `Army1 must defeat Army2`() {
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
    @Test
    fun `Battle 11`() {
        // given
        val army1 = Army().apply {
            addUnits(5) { Defender() }
            addUnits(6) { Vampire() }
            addUnits(7) { Warrior() }
        }
        val army2 = Army().apply {
            addUnits(6) { Warrior() }
            addUnits(6) { Defender() }
            addUnits(6) { Vampire() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    fun `Battle 12`() {
        // given
        val army1 = Army().apply {
            addUnits(2) { Defender() }
            addUnits(3) { Vampire() }
            addUnits(4) { Warrior() }
        }
        val army2 = Army().apply {
            addUnits(4) { Warrior() }
            addUnits(4) { Defender() }
            addUnits(3) { Vampire() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    fun `Battle 13`() {
        // given
        val army1 = Army().apply {
            addUnits(11) { Defender() }
            addUnits(3) { Vampire() }
            addUnits(4) { Warrior() }
        }
        val army2 = Army().apply {
            addUnits(4) { Warrior() }
            addUnits(4) { Defender() }
            addUnits(13) { Vampire() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

    @Test
    fun `Battle 14`() {
        // given
        val army1 = Army().apply {
            addUnits(9) { Defender() }
            addUnits(3) { Vampire() }
            addUnits(8) { Warrior() }
        }
        val army2 = Army().apply {
            addUnits(4) { Warrior() }
            addUnits(4) { Defender() }
            addUnits(13) { Vampire() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

    @Test
    fun `Battle 15`() {
        // given
        val army1 = Army().apply {
            addUnits(5) { Lancer() }
            addUnits(3) { Vampire() }
            addUnits(4) { Warrior() }
            addUnits(2) { Defender() }
        }
        val army2 = Army().apply {
            addUnits(4) { Warrior() }
            addUnits(4) { Defender() }
            addUnits(6) { Vampire() }
            addUnits(5) { Lancer() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res)
    }

    @Test
    fun `Battle 16`() {
        // given
        val army1 = Army().apply {
            addUnits(7) { Lancer() }
            addUnits(3) { Vampire() }
            addUnits(4) { Warrior() }
            addUnits(2) { Defender() }
        }
        val army2 = Army().apply {
            addUnits(4) { Warrior() }
            addUnits(4) { Defender() }
            addUnits(6) { Vampire() }
            addUnits(4) { Lancer() }
        }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res)
    }

    @Test
    fun `Battle 17`() {
        // given
        val armyWarrior = Army().apply {
            addUnits(2) { Warrior() }
        }
        val armyLancer = Army().apply {
            addUnits(1) { Lancer() }
            addUnits(1) { Warrior() }
        }
        // when
        val res = fight(armyWarrior, armyLancer)
        // then
        assertEquals(false, res)
    }



}