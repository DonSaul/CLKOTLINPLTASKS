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


    @Test
    @DisplayName("x. Vampire vs Vampire")
    internal fun `Vampire vs Vampire`() {
        val vampire = Vampire()

        fight(vampire, Vampire())

        assertEquals(4, vampire.health)
    }

    @Test
    @DisplayName("1. Vampire vs Rookie")
    internal fun `Vampire vs Rookie`() {
        class Rookie : Warrior(attack = 1)
        val vampire = Vampire()
        val initialHealth = vampire.health

        fight(vampire, Rookie())

        assertEquals(initialHealth, vampire.health)
    }





}