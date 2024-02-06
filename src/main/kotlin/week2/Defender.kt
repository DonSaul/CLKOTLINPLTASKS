package week2

class Defender():Warrior(health=60, attack =3 ) {
    val defense:Int=2

    override fun takeDamage(damage: Int):Int {

        if (damage> defense){
            health-=damage-defense
            return damage-defense
        }

        return damage
    }

}