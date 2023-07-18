package designPatterns.behavior.templateMethod.example1

/**
 * The method prepare() is the template method because it follows a template or pattern for defining an algorithm.
 * If you need, you can do some private methods to encapsulate common behaviors.
 * And the abstract methods will be implemented in your concrete classes.
 */
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