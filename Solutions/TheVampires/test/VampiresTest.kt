import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer

@TestMethodOrder(MethodOrderer.DisplayName::class)
class VampiresTest {

    @Test
    @DisplayName("Fight Test 1: Warrior loses to Knight")
    fun warriorLosesToKnight() {
        val carl = Warrior()
        val jim = Knight()
        val result = fight(carl, jim)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Fight Test 2: Knight wins against Warrior")
    fun knightWinsAgainstWarrior() {
        val ramon = Knight()
        val slevin = Warrior()
        val result = fight(ramon, slevin)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Fight Test 3: Warrior survives fighting another Warrior")
    fun warriorSurvivesFightingAnotherWarrior() {
        val bob = Warrior()
        val mars = Warrior()
        fight(bob, mars)
        assertEquals(true, bob.isAlive)
    }

    @Test
    @DisplayName("Fight Test 4: Knight survives fighting Warrior")
    fun knightSurvivesFightingWarrior() {
        val zeus = Knight()
        val godkiller = Warrior()
        fight(zeus, godkiller)
        assertEquals(true, zeus.isAlive)
    }

    @Test
    @DisplayName("Fight Test 5: Warrior dies fighting another Warrior")
    fun warriorDiesFightingAnotherWarrior() {
        val husband = Warrior()
        val wife = Warrior()
        fight(husband, wife)
        assertEquals(false, wife.isAlive)
    }

    @Test
    @DisplayName("Fight Test 6: Knight survives fighting Warrior")
    fun knightSurvivesFightingWarriorSecondCase() {
        val dragon = Warrior()
        val knight = Knight()
        fight(dragon, knight)
        assertEquals(true, knight.isAlive)
    }

    @Test
    @DisplayName("Fight Test 7: Knight loses when fighting consecutively")
    fun knightLosesWhenFightingConsecutively() {
        val unit1 = Warrior()
        val unit2 = Knight()
        val unit3 = Warrior()
        fight(unit1, unit2)
        val result = fight(unit2, unit3)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Fight Test 8: Defender stands after Rookie attack")
    fun defenderStandsAfterRookieAttack() {
        val unit1 = Defender()
        val unit2 = Rookie()
        fight(unit1, unit2)
        assertEquals(60, unit1.health)
    }

    @Test
    @DisplayName("Fight Test 9: Defender wins against Warrior after fighting Rookie")
    fun defenderWinsAgainstWarriorAfterFightingRookie() {
        val unit1 = Defender()
        val unit2 = Rookie()
        val unit3 = Warrior()
        fight(unit1, unit2)
        val result = fight(unit1, unit3)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 1: Army of 1 Warrior loses to Army of 2 Warriors")
    fun armyOfOneWarriorLosesToArmyOfTwoWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(1) { Warrior() }
        army2.addUnits(2) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 2: Army of 2 Warriors loses to Army of 3 Warriors")
    fun armyOfTwoWarriorsLosesToArmyOfThreeWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Warrior() }
        army2.addUnits(3) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 3: Army of 5 Warriors loses to Army of 7 Warriors")
    fun armyOfFiveWarriorsLosesToArmyOfSevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army2.addUnits(7) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 4: Army of 20 Warriors loses to Army of 21 Warriors")
    fun armyOfTwentyWarriorsLosesToArmyOfTwentyOneWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 5: Army of 10 Warriors loses to Army of 11 Warriors")
    fun armyOfTenWarriorsLosesToArmyOfElevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army2.addUnits(11) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 6: Army of 11 Warriors wins against Army of 7 Warriors")
    fun armyOfElevenWarriorsWinsAgainstArmyOfSevenWarriors() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(11) { Warrior() }
        army2.addUnits(7) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 7: Army with Warriors and Defenders wins against smaller Army")
    fun armyWithWarriorsAndDefendersWinsAgainstSmallerArmy() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(4) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 8: Mixed Army wins against slightly larger Warrior Army")
    fun mixedArmyWinsAgainstSlightlyLargerWarriorArmy() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Defender() }
        army1.addUnits(20) { Warrior() }
        army2.addUnits(21) { Warrior() }
        army1.addUnits(4) { Defender() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 9: Army with Defenders and Warriors wins against smaller Army")
    fun armyWithDefendersAndWarriorsWinsAgainstSmallerArmy() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(5) { Warrior() }
        army1.addUnits(10) { Defender() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 10: Small Mixed Army loses to larger Warrior Army")
    fun smallMixedArmyLosesToLargerWarriorArmy() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Warrior() }
        army1.addUnits(1) { Defender() }
        army2.addUnits(5) { Warrior() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 11: Mixed Army battles against a balanced army")
    fun mixedArmyBattlesAgainstBalancedArmy() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Defender() }
        army1.addUnits(6) { Vampire() }
        army1.addUnits(7) { Warrior() }
        army2.addUnits(6) { Warrior() }
        army2.addUnits(6) { Defender() }
        army2.addUnits(6) { Vampire() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 12: Smaller mixed armies engage")
    fun smallerMixedArmiesEngage() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Warrior() }
        army2.addUnits(4) { Warrior() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(3) { Vampire() }
        val result = battle(army1, army2)
        assertEquals(false, result)
    }

    @Test
    @DisplayName("Battle Test 13: Defender and Vampire heavy army wins")
    fun defenderAndVampireHeavyArmyWins() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(11) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(4) { Warrior() }
        army2.addUnits(4) { Warrior() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(13) { Vampire() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

    @Test
    @DisplayName("Battle Test 14: Large mixed army secures a victory")
    fun largeMixedArmySecuresVictory() {
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(9) { Defender() }
        army1.addUnits(3) { Vampire() }
        army1.addUnits(8) { Warrior() }
        army2.addUnits(4) { Warrior() }
        army2.addUnits(4) { Defender() }
        army2.addUnits(13) { Vampire() }
        val result = battle(army1, army2)
        assertEquals(true, result)
    }

}
