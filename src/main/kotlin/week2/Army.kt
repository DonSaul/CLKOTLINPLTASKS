package week2

class Army {
    val units= mutableListOf<Warrior>()
    fun addUnits(numberOfUnits:Int,unitFactory: () -> Warrior){
        repeat(numberOfUnits){
            units.add(unitFactory())
        }
    }
}