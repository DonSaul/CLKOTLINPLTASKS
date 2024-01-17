package task2;

class Wizard(
           name:String,
           healthPoints:Int,
           attackPoints:Int,
         private val manaPoints:Int
) : Character(name, healthPoints, attackPoints) {

    override fun attack(target: Character){

        var totalDamage=attackPoints
        val spellCost=2
        val spellAttack=3
        println("$name attacked ${target.characterName} and dealt $attackPoints points of damage.")
        if (manaPoints>=spellCost){

            println("$name deals an additional $spellAttack points of magical damage")
            totalDamage+=spellAttack
        }
        target.takeDamage(totalDamage)
    }







}
