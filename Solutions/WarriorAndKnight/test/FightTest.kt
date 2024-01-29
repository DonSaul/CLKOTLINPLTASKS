import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.DisplayName::class)
class FightTest {

    @Test
    @DisplayName("Fight Test 1: Warrior loses to Knight")
    fun warriorLosesToKnight() {
        // given
        val carl = Warrior()
        val jim = Knight()

        // when
        val result = fight(carl, jim)

        // then
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Fight Test 2: Knight wins against Warrior")
    fun knightWinsAgainstWarrior() {
        // given
        val ramon = Knight()
        val slevin = Warrior()

        // when
        val result = fight(ramon, slevin)

        // then
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Fight Test 3: Warrior survives fighting another Warrior")
    fun warriorSurvivesFightingAnotherWarrior() {
        // given
        val bob = Warrior()
        val mars = Warrior()

        // when
        fight(bob, mars)

        // then
        assertEquals(true, bob.isAlive)
    }

    @Test
    @DisplayName("Fight Test 4: Knight survives fighting Warrior")
    fun knightSurvivesFightingWarrior() {
        // given
        val zeus = Knight()
        val godkiller = Warrior()

        // when
        fight(zeus, godkiller)

        // then
        assertEquals(true, zeus.isAlive)
    }

    @Test
    @DisplayName("Fight Test 5: Warrior dies fighting another Warrior")
    fun warriorDiesFightingAnotherWarrior() {
        // given
        val husband = Warrior()
        val wife = Warrior()

        // when
        fight(husband, wife)

        // then
        assertEquals(false, wife.isAlive)
    }

    @Test
    @DisplayName("Fight Test 6: Knight survives fighting Warrior")
    fun knightSurvivesFightingWarriorSecondCase() {
        // given
        val dragon = Warrior()
        val knight = Knight()

        // when
        fight(dragon, knight)

        // then
        assertEquals(true, knight.isAlive)
    }

    @Test
    @DisplayName("Fight Test 7: Knight loses when fighting consecutively")
    fun knightLosesWhenFightingConsecutively() {
        // given
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()

        // when
        fight(unit1, unit2)
        val result = fight(unit2, unit3)

        // then
        assertEquals(false, result)
    }
}
