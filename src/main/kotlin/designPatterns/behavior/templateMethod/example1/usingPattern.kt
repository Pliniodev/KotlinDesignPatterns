package designPatterns.behavior.templateMethod.example1

import divider

/**
 * On example1 we just run some behaviors, we don't need to return anything
 */
private fun prepareDrinksWithTemplateMethod(){
    val tea = Tea()
    tea.prepare()
    divider()
    val coffee = Coffee()
    coffee.prepare()
    divider()
}

private fun main() {
    prepareDrinksWithTemplateMethod()
}