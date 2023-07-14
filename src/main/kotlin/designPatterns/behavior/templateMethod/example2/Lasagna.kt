package designPatterns.behavior.templateMethod.example2

class Lasagna(oven: Oven) : AbstractRecipe(oven) {
    override fun serve() {
        println("Serving hot lasagna")
    }
}
