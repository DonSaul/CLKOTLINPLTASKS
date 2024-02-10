package weeks.week01
open class Warrior(
     var health: Double = 50.0,
     val attack: Double = 5.0
) {


    val isAlive: Boolean
        get() = health > 0.0

    open fun receiveDamage(damage: Double) {
        health -= damage
        if (health < 0.0) {
            health = 0.0
        }
    }
}

class Lancer : Warrior(health = 50.0, attack = 6.0)


class Defender : Warrior(health = 60.0, attack = 3.0) {
    private val defense: Double = 2.0
    fun getDefense(): Double {
        return defense
    }
    override fun receiveDamage(damage: Double) {
        if (damage > defense) {
            super.receiveDamage(damage - defense)
        }
    }
}

class Knight : Warrior(health = 50.0, attack = 7.0){
    override fun receiveDamage(damage: Double) {
        health -= damage
        if (health < 0) {
            health = 0.0
        }
    }
}
open class Vampire : Warrior(health = 40.0, attack = 4.0) {
    private val vampirePercentage: Double = 50.0
    private val initialHealth = health
    fun getVampirePercentage(): Double {
        return vampirePercentage
    }
    override fun receiveDamage(damage: Double) {
        health -= damage
        if (health < 0) {
            health = 0.0
        }
    }
    open fun receiveHealing(healing: Double) {
        if(initialHealth > health) {
            health += healing
        }
    }
}

class Rookie : Warrior(health = 50.0, attack = 1.0)

class Healer : Warrior(health = 60.0, attack = 0.0) {
    fun heal(ally: Warrior) {
        val maxHealth = ally.health
        val currentHealth = ally.health
        if (currentHealth < maxHealth) {
            val newHealth = minOf(currentHealth + 2, maxHealth)
            ally.health = newHealth
        }
    }

    override fun receiveDamage(damage: Double) {
    }
}

fun fight(fighter1: Warrior, fighter2: Warrior): Boolean {
    var currentAttacker = fighter1
    var currentDefender = fighter2

    val initialHealth1 = fighter1.health
    val initialHealth2 = fighter2.health

    while (currentAttacker.isAlive && currentDefender.isAlive) {
        val damage = currentAttacker.attack

        if (currentAttacker is Vampire) {
            val vampireDivided = currentAttacker.getVampirePercentage() /100
            if (currentDefender is Defender){

                val actualAttack = currentAttacker.attack - currentDefender.getDefense()
                val healing = (actualAttack * vampireDivided)
                currentAttacker.receiveHealing(healing)
            }
            else{
                val healing = (currentAttacker.attack * vampireDivided)
                currentAttacker.receiveHealing(healing)
            }

        }

        currentDefender.receiveDamage(damage)


        if (currentAttacker.health == initialHealth1 && currentDefender.health == initialHealth2) {
            break
        }

        val temp = currentAttacker
        currentAttacker = currentDefender
        currentDefender = temp
    }

    return fighter1.isAlive
}

fun main() {
    val warrior = Warrior()
    val defender = Defender()
    val result = fight(warrior, defender)

    println(result)
}


