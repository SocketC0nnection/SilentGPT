package net.socket.silentgpt.commands;

public abstract class Command {

    private final String command;

    public Command(String command) {
        this.command = command;
    }

    public abstract void onExecute();

    public String getCommand() {
        return command;
    }
}
