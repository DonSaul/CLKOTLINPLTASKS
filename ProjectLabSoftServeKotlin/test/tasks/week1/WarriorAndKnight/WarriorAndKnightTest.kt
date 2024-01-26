package tasks.week1.WarriorAndKnight

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.assertEquals

class WarriorAndKnightTest {

    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        val carl = Warrior()
        val jim = Knight()
        val res = fight(carl, jim)
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Warrior wins when fights against Knight, Knight going first`() {
        val ramon = Knight()
        val slevin = Warrior()
        val res = fight(ramon, slevin)
        assertEquals(true, res)
    }

    @Test
    @DisplayName("3. Fight")
    fun `Winner is alive after fight, Warrior vs Warrior`() {
        val bob = Warrior()
        val mars = Warrior()
        fight(bob, mars)
        val res = bob.isAlive
        assertEquals(true, res)
    }

    @Test
    @DisplayName("4. Fight")
    fun `Knight is alive after fight, Knight v Warrior`() {
        val zeus = Knight()
        val godkiller = Warrior()
        fight(zeus, godkiller)
        val res = zeus.isAlive
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Loser is not alive after fight, Warrior v Warrior`() {
        val husband = Warrior()
        val wife = Warrior()
        fight(husband, wife)
        val res = wife.isAlive
        assertEquals(false, res)
    }

    @Test
    @DisplayName("6. Fight")
    fun `Winner is alive after fight, Warrior v Knight`() {
        val dragon = Warrior()
        val knight = Knight()
        fight(dragon, knight)
        val res = knight.isAlive
        assertEquals(true, res)
    }

    @Test
    @DisplayName("7. Fight")
    fun `Knight loses against warrior, after having previous fight`() {
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()
        fight(unit1, unit2)
        val res = fight(unit2, unit3)
        assertEquals(false, res)
    }
}
