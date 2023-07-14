package designPatterns.behavior.templateMethod.example2

abstract class AbstractRecipe(private val oven: Oven) {
    fun cook() {
        prepareIngredients()
        oven.preheat()
        oven.cook()
        oven.cool()
        serve()
    }

    private fun prepareIngredients() {
        println("Preparing the ingredients")
    }

    protected abstract fun serve()
}