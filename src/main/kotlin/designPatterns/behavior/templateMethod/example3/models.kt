package designPatterns.behavior.templateMethod.example3

data class House(
    val terrain: Terrain,
    val foundation: Foundation,
    val walls: Walls,
    val roof: Roof,
    val interior: Interior
)

data class Terrain(val type: String)
data class Foundation(val type: String)
data class Walls(val type: String)
data class Roof(val type: String)
data class Interior(val type: String)