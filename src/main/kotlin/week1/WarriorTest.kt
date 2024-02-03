package week1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
class WarriorTest {
//https://github.com/CheckiO-Missions/checkio-mission-set-war-the-warriors/blob/master/verification/tests.py
    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        // given
        val carl = Warrior()
        val jim = Knight()
        // when
        val res = fight(carl, jim)
        // then
        Assertions.assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Warrior loses when fights against Knight, Knight going first`(){

        val ramon= Knight()
        val slevin= Warrior()

        val res= fight(ramon,slevin)

        Assertions.assertEquals(true,res)

    }

    @Test
    @DisplayName("3. Fight")
    fun `Winner is alive after fight, Warrior v Warrior`(){
        val bob= Warrior()
        val mars= Warrior()

        fight(bob,mars)
        val res= bob.isAlive

        Assertions.assertEquals(true,res)

    }

    @Test
    @DisplayName("4. Fight")
    fun `Knight is alive after fight, Knight v Warrior`() {
        // Given
        val zeus = Knight()
        val godkiller = Warrior()

        // When
        fight(zeus, godkiller)

        // Then
        val res = zeus.isAlive
        Assertions.assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Loser is not alive after fight, Warrior v Warrior`(){
        val husband= Warrior()
        val wife= Warrior()

        fight(husband,wife)

        val res=wife.isAlive

        Assertions.assertEquals(false,res)
    }

    @Test
    @DisplayName("6. Fight")
    fun `Winner is alive after fight, Warrior v Knight`(){
        val knight= Knight()
        val dragon= Warrior()

        fight(dragon,knight)

        val res=knight.isAlive

        Assertions.assertEquals(true,res)
    }

    @Test
    @DisplayName("7. Fight")
    fun `Knight loses against warrior, after having previous fight`(){
        //Given
        val unit1= Warrior()
        val unit2= Knight()
        val unit3= Warrior()

        //When
        fight(unit1,unit2)
        val res=fight(unit2,unit3)

        //Then
        Assertions.assertEquals(false,res)

    }



}