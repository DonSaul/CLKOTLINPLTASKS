package week2

class Vampire():Warrior(health=40,attack=4) {
    val vampirism=50
    val maxHealth=40


    override fun attack(warrior: Warrior): Int {
        val damageDealt=warrior.takeDamage(attack)
        val healing= damageDealt* vampirism/100

        health+=healing

        if (health>maxHealth){
            health=maxHealth
        }

        return damageDealt

    }


}