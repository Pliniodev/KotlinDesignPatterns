package designPatterns.behavior.templateMethod.example2

class Cake(oven: Oven) : AbstractRecipe(oven) {
    override fun serve() {
        println("Serving decorated cake")
    }
}