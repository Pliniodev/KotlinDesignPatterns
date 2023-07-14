package designPatterns.behavior.templateMethod.example3

abstract class AbstractHouseBuilder {
    fun buildHouse(): House {
        val terrain = buyTerrain()
        val foundation = layFoundation()
        val walls = buildWalls()
        val roof = constructRoof()
        val interior = designInterior()

        return House(terrain, foundation, walls, roof, interior)
    }

    //if some step of creation is identical in all House objects,
    //just create a private fun for this in abstract class like:
    private fun buyTerrain(): Terrain {
        return Terrain(type = "Some beautiful terrain")
    }

    protected abstract fun layFoundation(): Foundation
    protected abstract fun buildWalls(): Walls
    protected abstract fun constructRoof(): Roof
    protected abstract fun designInterior(): Interior
}