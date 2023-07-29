package designPatterns.behavior.command.exemplo1.commands

import designPatterns.behavior.command.exemplo1.LightCommand
import designPatterns.behavior.command.exemplo1.receiver.Light

// Concrete command OnCommand
class CommandOn(private val light: Light) : LightCommand {
    override fun execute() {
        light.turnOn()
    }
}

