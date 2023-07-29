package designPatterns.behavior.command.exemplo2.receiver

// Receiver class (Car)
class Car {
    fun startEngine() {
        println("Engine started!")
    }

    fun stopEngine() {
        println("Engine stopped!")
    }

    fun accelerate() {
        println("Car is accelerating!")
    }

    fun brake() {
        println("Car is braking!")
    }
}