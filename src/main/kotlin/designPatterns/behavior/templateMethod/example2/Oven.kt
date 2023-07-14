package designPatterns.behavior.templateMethod.example2

interface Oven {
    fun preheat()
    fun cook()
    fun cool()
}

class GasOven : Oven {
    override fun preheat() {
        println("Preheating the gas oven")
    }

    override fun cook() {
        println("Cooking in the gas oven")
    }

    override fun cool() {
        println("Cooling in the gas oven")
    }
}







