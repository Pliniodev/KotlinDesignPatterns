package designPatterns.behavior.command.exemplo2

import designPatterns.behavior.command.exemplo2.commands.AccelerateCommand
import designPatterns.behavior.command.exemplo2.commands.BrakeCommand
import designPatterns.behavior.command.exemplo2.commands.StartEngineCommand
import designPatterns.behavior.command.exemplo2.commands.StopEngineCommand
import designPatterns.behavior.command.exemplo2.invoker.CarControl
import designPatterns.behavior.command.exemplo2.receiver.Car

fun main() {
    val car = Car()
    val startEngineCommand = StartEngineCommand(car)
    val stopEngineCommand = StopEngineCommand(car)
    val accelerateCommand = AccelerateCommand(car)
    val brakeCommand = BrakeCommand(car)

    val carControl = CarControl()

    // Configuring the car remote with different commands
    carControl.setCommand(startEngineCommand)
    carControl.pressButton()

    carControl.setCommand(accelerateCommand)
    carControl.pressButton()

    carControl.setCommand(brakeCommand)
    carControl.pressButton()

    carControl.setCommand(stopEngineCommand)
    carControl.pressButton()
}
