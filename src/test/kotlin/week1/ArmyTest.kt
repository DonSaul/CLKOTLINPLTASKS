package week1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class ArmyTest{

    @Test
    @DisplayName("1. Battle")
    fun `One warrior army v two warrior army returns false`(){
        val army1=Army()
        val army2=Army()

        army1.addUnits(1){ Warrior() }
        army2.addUnits(2){Warrior()}

        val res=fight(army1,army2)
        assertEquals(false,res)

    }

    @Test
    @DisplayName("2. Battle")
    fun `two warrior army v three warrior army returns false`(){
        val army1=Army()
        val army2=Army()

        army1.addUnits(2){ Warrior() }
        army2.addUnits(3){Warrior()}

        val res=fight(army1,army2)
        assertEquals(false,res)


    }

    @Test
    @DisplayName("3. Battle")
    fun `five warrior army v seven warrior army returns false`(){
        val army1=Army()
        val army2=Army()

        army1.addUnits(5){ Warrior() }
        army2.addUnits(7){Warrior()}

        val res=fight(army1,army2)
        assertEquals(false,res)


    }

    @Test
    @DisplayName("4. Battle")
    fun `twenty warrior army v twentyone warrior army returns true`(){
        val army1=Army()
        val army2=Army()

        army1.addUnits(20){ Warrior() }
        army2.addUnits(21){Warrior()}

        val res=fight(army1,army2)
        assertEquals(true,res)


    }

    @Test
    @DisplayName("5. Battle")
    fun `ten warrior army v eleven warrior army returns true`(){
        val army1=Army()
        val army2=Army()

        army1.addUnits(20){ Warrior() }
        army2.addUnits(21){Warrior()}

        val res=fight(army1,army2)
        assertEquals(true,res)


    }

    @Test
    @DisplayName("6. Battle")
    fun `eleven warrior army v seven warrior army returns true`(){
        //Given
        val army1=Army()
        val army2=Army()
        army1.addUnits(11){ Warrior() }
        army2.addUnits(7){Warrior()}

        //When
        val res=fight(army1,army2)

        //Then
        assertEquals(true,res)

    }





}