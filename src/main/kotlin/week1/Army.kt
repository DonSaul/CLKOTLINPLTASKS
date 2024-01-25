package week1

class Army {
    val units= mutableListOf<Warrior>()

    fun addUnits(numberOfUnits:Int,unitFactory: () -> Warrior){
        repeat(numberOfUnits){
            units.add(unitFactory())
        }



    }
}