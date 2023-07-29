package designPatterns.behavior.command.exemplo2.invoker

import designPatterns.behavior.command.exemplo2.CarCommand

// Invoker class (CarRemote)
class CarControl {
    private var command: CarCommand? = null

    fun setCommand(command: CarCommand) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}