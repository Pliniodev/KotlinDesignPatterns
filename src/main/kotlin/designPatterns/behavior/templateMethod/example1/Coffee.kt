package designPatterns.behavior.templateMethod.example1

class Coffee : AbstractDrink() {
    override fun brew() {
        println("Preparing coffee")
    }

    override fun addIngredients() {
        println("Adds suggar and milk")
    }
}