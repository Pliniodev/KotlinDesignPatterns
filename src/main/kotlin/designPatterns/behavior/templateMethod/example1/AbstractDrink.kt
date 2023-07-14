package designPatterns.behavior.templateMethod.example1

abstract class AbstractDrink {
    fun prepare() {
        boilWater()
        brew()
        pourInCup()
        addIngredients()
        mix()
    }
    private fun boilWater() { println("boiling the water") }

    protected abstract fun brew()

    private fun pourInCup() { println("Pouring the drink in the cup") }

    protected abstract fun addIngredients()

    private fun mix() { println("Mixing the drink") }
}