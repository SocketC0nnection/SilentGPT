package net.socket.silentgpt.managers;

import net.socket.silentgpt.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private final List<Command> commands;

    public CommandManager() {
        commands = new ArrayList<>();
    }

    public void register(Command command) {
        commands.add(command);
    }

    public Command getCommand(String commandName) {
        for(Command command : commands) {
            if(!command.getCommand().equals(commandName)) {
                continue;
            }

            return command;
        }

        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
