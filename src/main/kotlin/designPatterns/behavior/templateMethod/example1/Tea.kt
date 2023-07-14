package designPatterns.behavior.templateMethod.example1

class Tea : AbstractDrink() {
    override fun brew() {
        println("Preparing tea")
    }

    override fun addIngredients() {
        println("Adds lemon")
    }
}