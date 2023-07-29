package designPatterns.behavior.command.exemplo2.commands

import designPatterns.behavior.command.exemplo2.CarCommand
import designPatterns.behavior.command.exemplo2.receiver.Car

// Concrete command StartEngineCommand
class StartEngineCommand(private val car: Car) : CarCommand {
    override fun execute() {
        car.startEngine()
    }
}