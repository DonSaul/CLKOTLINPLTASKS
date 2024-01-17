package task2

open class Character (
    protected val name:String,
    protected var healthPoints:Int,
    protected val attackPoints:Int,
) {
    //test
    val characterName: String
        get() = name

    open fun takeDamage(damage:Int){
        healthPoints-=damage

        println("$name took $damage points of damage. Health:$healthPoints")
    }

    open fun attack(target:Character){
        println("$name attacked ${target.name} and dealt $attackPoints points of damage.")
        target.takeDamage(attackPoints)
    }





}