
package weeks.week01

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class WarriorAndKnightFightTest {

    @Test
    @DisplayName("Fight 1")
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
    @DisplayName("Fight 2")
    fun `Knight wins when fights against Warrior`() {
        // Arrange
        val ramon = Knight()
        val kevin = Warrior()
        // Act
        val result = fight(ramon, kevin)
        // Assert
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Fight 3")
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
    @DisplayName("Fight 4")
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
    @DisplayName("Fight 5")
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
    @DisplayName("Fight 6")
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
    @DisplayName("Fight 7")
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

    @Test
    @DisplayName("Fight 8")
    fun `Vampire vs Vampire`() {
        val vampire1 = Vampire()
        val vampire2 = Vampire()

        val result = fight(vampire1, vampire2)

        assertEquals(true, result)
    }

    @Test
    @DisplayName("Fight 9")
    fun `Vampire vs Rookie`() {
        val vampire = Vampire()
        val rookie = Rookie()

        val result = fight(vampire, rookie)

        assertEquals(true, result)
    }
}