package designPatterns.behavior.templateMethod.example3

import divider

/**
 * In example3, imagine this, we need to create objects at each step and return a
 * Main object (House), but we need to create two types of Houses (Modern and Traditional)
 * Each one created with its particular rules.
 */
private fun main() {
    val modernHouseBuilder = ModernHouseBuilder()
    val modernHouse = modernHouseBuilder.buildHouse()
    println("Modern House:")
    println(modernHouse)

    divider()

    val traditionalHouseBuilder = TraditionalHouseBuilder()
    val traditionalHouse = traditionalHouseBuilder.buildHouse()
    println("Traditional House:")
    println(traditionalHouse)
}