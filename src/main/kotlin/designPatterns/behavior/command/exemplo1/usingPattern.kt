package designPatterns.behavior.command.exemplo1

import designPatterns.behavior.command.exemplo1.commands.CommandOff
import designPatterns.behavior.command.exemplo1.commands.CommandOn
import designPatterns.behavior.command.exemplo1.invoker.RemoteControl
import designPatterns.behavior.command.exemplo1.receiver.Light

fun main() {
    val light = Light()
    val turnOnCommand = CommandOn(light)
    val turnOffCommand = CommandOff(light)

    val remoteControl = RemoteControl()

    // Setting up the remote control to turn on the light
    remoteControl.setCommand(turnOnCommand)

    // Pressing the button - the light will be turned on
    remoteControl.pressButton()

    // Configuring the remote control to turn off the light
    remoteControl.setCommand(turnOffCommand)

    // Pressing the button again - the light will be turned off
    remoteControl.pressButton()
}
