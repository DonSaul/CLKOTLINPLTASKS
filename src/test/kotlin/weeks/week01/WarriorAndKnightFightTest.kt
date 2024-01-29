
package weeks.week01

import Warrior
import Knight
import fight
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class WarriorAndKnightFightTest {

    @Test
    fun `Warrior loses when fights against Knight`() {
        // Arrange
        val carl = Warrior()
        val jim = Knight()
        // Act
        val result = fight(carl, jim)
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun `Knight wins when fights against Warrior`() {
        // Arrange
        val ramon = Knight()
        val slevin = Warrior()
        // Act
        val result = fight(ramon, slevin)
        // Assert
        assertEquals(true, result)
    }

    @Test
    fun `Warrior remains alive after self-fight`() {
        // Arrange
        val bob = Warrior()
        val mars = Warrior()
        // Act
        fight(bob, mars)
        // Assert
        assertEquals(true, bob.isAlive)
    }

    @Test
    fun `Knight remains alive after defeating Warrior`() {
        // Arrange
        val zeus = Knight()
        val godkiller = Warrior()
        // Act
        fight(zeus, godkiller)
        // Assert
        assertEquals(true, zeus.isAlive)
    }

    @Test
    fun `Warrior dies when fights against another Warrior`() {
        // Arrange
        val husband = Warrior()
        val wife = Warrior()
        // Act
        fight(husband, wife)
        // Assert
        assertEquals(false, wife.isAlive)
    }

    @Test
    fun `Knight remains alive after defeating Warrior (different scenario)`() {
        // Arrange
        val dragon = Warrior()
        val knight = Knight()
        // Act
        fight(dragon, knight)
        // Assert
        assertEquals(true, knight.isAlive)
    }

    @Test
    fun `Second Warrior loses when fights against Knight`() {
        // Arrange
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()
        // Act
        fight(unit1, unit2)
        val result = fight(unit2, unit3)
        // Assert
        assertEquals(false, result)
    }
}