package designPatterns.behavior.templateMethod.example3

class TraditionalHouseBuilder : AbstractHouseBuilder() {
    override fun layFoundation(): Foundation {
        println("Laying foundation for a traditional house")
        return Foundation("Traditional Foundation")
    }

    override fun buildWalls(): Walls {
        println("Building walls for a traditional house")
        return Walls("Traditional Walls")
    }

    override fun constructRoof(): Roof {
        println("Constructing roof for a traditional house")
        return Roof("Traditional Roof")
    }

    override fun designInterior(): Interior {
        println("Designing interior for a traditional house")
        return Interior("Traditional Interior")
    }
}