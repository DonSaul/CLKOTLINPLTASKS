package week2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WarriorTest{

    @Test
    @DisplayName("1. Rookie Defender Fight")
    internal fun `When Defender fights against Rookie his health won't increase`() {
        //Given
        class Rookie : Warrior(attack = 1)
        val defender = Defender()
        val initialHealth = defender.health
        //When
        fight(defender, Rookie())
        //Then
        assertEquals(initialHealth, defender.health)
    }





}