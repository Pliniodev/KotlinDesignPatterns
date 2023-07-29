package designPatterns.behavior.command.exemplo1.invoker

import designPatterns.behavior.command.exemplo1.LightCommand

// Invoker class (RemoteControl)
class RemoteControl {
    private var command: LightCommand? = null

    fun setCommand(command: LightCommand) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}