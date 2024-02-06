package week2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ArmyTest{

    @Test
    @DisplayName("7. Battle")
    fun `five warrior 9 Defender army v four warrior army returns true`() {
        //Given
        val army1=Army()
        val army2=Army()
        army1.addUnits(5){Warrior()}
        army1.addUnits(4){Defender()}
        army1.addUnits(5){Defender()}
        army2.addUnits(4){Warrior()}
        //When
        val res= fight(army1,army2)
        //Then
        assertEquals(true,res)

    }

    @Test
    @DisplayName("8. Battle")
    fun `five Defender 41 Warrior army v four Defender army returns true`() {
        //Given
        val army1=Army()
        val army2=Army()
        army1.addUnits(5){Defender()}
        army1.addUnits(20){Warrior()}
        army1.addUnits(21){Warrior()}
        army2.addUnits(4){Defender()}
        //When
        val res= fight(army1,army2)
        //Then
        assertEquals(true,res)

    }

    @Test
    @DisplayName("9. Battle")
    fun `ten warrior ten Defender army v ten Warrior army returns true`() {
        //Given
        val army1=Army()
        val army2=Army()
        army1.addUnits(10){Warrior()}
        army1.addUnits(5){Defender()}
        army2.addUnits(10){Warrior()}
        army1.addUnits(5){Defender()}
        //When
        val res= fight(army1,army2)
        //Then
        assertEquals(true,res)

    }

    @Test
    @DisplayName("10. Battle")
    fun `one warrior three defender army v five Warrior one defender army returns true`() {
        //Given
        val army1=Army()
        val army2=Army()
        army1.addUnits(2){Defender()}
        army1.addUnits(1){Warrior()}
        army1.addUnits(1){Defender()}
        army2.addUnits(5){Warrior()}
        //When
        val res= fight(army1,army2)
        //Then
        assertEquals(false,res)

    }








}