class Army {

    val units = mutableListOf<Warrior>();

    fun addUnits(quantity: Int, createUnit: () -> Warrior) {
        for(i in 1..quantity) {
            units.add(createUnit())
        }
    }
}