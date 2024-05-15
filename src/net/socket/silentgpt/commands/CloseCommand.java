package net.socket.silentgpt.commands;

public class CloseCommand extends Command {

    public CloseCommand() {
        super("SILENTGPT_CLOSE");
    }

    @Override
    public void onExecute() {
        System.exit(0);
    }

}
