class Army {

    val units = mutableListOf<Warrior>()

    fun addUnits(numberOfWarriors: Int, createWarrior: () -> Warrior) {
        repeat(numberOfWarriors) {
            units.add(createWarrior())
        }
    }
}