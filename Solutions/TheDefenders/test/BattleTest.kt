import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer

@TestMethodOrder(MethodOrderer.DisplayName::class)
class BattleTest {

    @Test
    @DisplayName("Battle Test 1: One Warrior loses to two Warriors")
    fun oneWarriorLosesToTwoWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 2: Two Warriors lose to three Warriors")
    fun twoWarriorsLoseToThreeWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Warrior() }
        army2.addUnits(3) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 3: Five Warriors lose to seven Warriors")
    fun fiveWarriorsLoseToSevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army2.addUnits(7) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 4: Twenty Warriors win against twenty-one Warriors")
    fun twentyWarriorsWinAgainstTwentyOneWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 5: Ten Warriors win against eleven Warriors")
    fun tenWarriorsWinAgainstElevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 6: Eleven Warriors win against seven Warriors")
    fun elevenWarriorsWinAgainstSevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }

        val result = battle(army1, army2)
        assertEquals(true, result)
    }
}
