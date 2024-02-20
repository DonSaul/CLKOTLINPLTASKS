package week2

class Lancer :Warrior(health =50 , attack = 6){


    override fun attack(warrior: Warrior): Int {
        return super.attack(warrior)
    }

     fun attackMultiple(warriorFront:Warrior,warriorBack:Warrior): Int{
         val percentageDealt=50

         val damageDealtFront=warriorFront.takeDamage(attack)
         val damageDealtBack=warriorBack.takeDamage(attack*percentageDealt/100)



        return damageDealtBack+damageDealtFront
    }


}