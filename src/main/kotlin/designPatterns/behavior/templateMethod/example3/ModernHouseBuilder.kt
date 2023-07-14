package designPatterns.behavior.templateMethod.example3

class ModernHouseBuilder : AbstractHouseBuilder() {
    override fun layFoundation(): Foundation {
        println("Laying foundation for a modern house")
        return Foundation("Modern Foundation")
    }

    override fun buildWalls(): Walls {
        println("Building walls for a modern house")
        return Walls("Modern Walls")
    }

    override fun constructRoof(): Roof {
        println("Constructing roof for a modern house")
        return Roof("Modern Roof")
    }

    override fun designInterior(): Interior {
        println("Designing interior for a modern house")
        return Interior("Modern Interior")
    }
}