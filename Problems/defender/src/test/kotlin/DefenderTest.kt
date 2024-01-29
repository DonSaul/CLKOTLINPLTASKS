import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class DefenderTest {
    @Test
    internal fun `When Defender fights against Rookie his health won't increase`() {
        val defender = Defender()
        val initialHealth = defender.health

        fight(defender, Rookie())

        assertEquals(initialHealth, defender.health)
    }

    @DisplayName("1. Fight")
    fun `Jon (caballero) debe ganar a Carl (guerrero)`() {
        // given
        val carl = Warrior()
        val jon = Knight()
        // when
        val res = fight(carl, jon)
        // then
        assertEquals(false, res)
    }

    @org.junit.jupiter.api.Test
    @DisplayName("8. Fight")
    fun `Defender vs Rockie, gana Defender sin afectar su nivel de salud`() {
        // given
        val unit1 = Defender()
        val unit2 = Rookie()
        // when
        fight(unit1, unit2)
        // then
        assertEquals(60, unit1.health ) {
            "El nivel de salud de defender cambió"
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("9. Fight")
    fun `Pelea triple, unit1 es debilitado por unit2, en su siguiente pelea gana a unit3`() {
        // given
        val unit1 = Defender()
        val unit2 = Rookie()
        val unit3 = Warrior()
        fight(unit1, unit2)
        // when
        val res = fight(unit1, unit3)
        // then
        assertEquals(true, res) {
            "No ganó unit1"
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1. Battle")
    fun `army1 vs army2, gana army1`(){
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(5) { Warrior() }
        army1.addUnits(4) { Defender() }
        army1.addUnits(5) { Defender() }
        army2.addUnits(4) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res) {
            "No ganó army1"
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2. Battle")
    fun `p2 army1 vs army2, gana army1`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(10) { Warrior() }
        army1.addUnits(5) { Defender() }
        army1.addUnits(5) { Warrior() }
        army2.addUnits(10) { Defender() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(true, res) {
            "No ganó army1"
        }
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3. Battle")
    fun `army1 vs army2, gana army2`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(2) { Defender() }
        army1.addUnits(1) { Warrior() }
        army1.addUnits(1) { Defender() }
        army2.addUnits(5) { Warrior() }
        // when
        val res = fight(army1, army2)
        // then
        assertEquals(false, res) {
            "No ganó army2"
        }
    }
}

