package designPatterns.behavior.command.exemplo2.commands

import designPatterns.behavior.command.exemplo2.CarCommand
import designPatterns.behavior.command.exemplo2.receiver.Car

// Concrete command AccelerateCommand
class AccelerateCommand(private val car: Car) : CarCommand {
    override fun execute() {
        car.accelerate()
    }
}