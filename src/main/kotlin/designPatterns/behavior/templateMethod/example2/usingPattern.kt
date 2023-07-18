package designPatterns.behavior.templateMethod.example2

import divider

/**
 * On example2 we use some injection, in this case, gas oven
 * Consider GasOven as some DataProvider
 */
private fun main() {
    println("Template Method")

    val electricOven: Oven = GasOven()
    val lasagna = Lasagna(electricOven)
    println("Preparing Lasagna:")
    lasagna.cook()

    divider()

    val gasOven: Oven = GasOven()
    val cake = Cake(gasOven)
    println("Preparing Cake:")
    cake.cook()
}