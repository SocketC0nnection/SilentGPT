package net.socket.silentgpt.commands;

import net.socket.silentgpt.SilentGPT;

public class StandbyCommand extends Command {

    public StandbyCommand() {
        super("SILENTGPT_STANDBY");
    }

    @Override
    public void onExecute() {
        SilentGPT.getInstance().toggleStandby();
    }

}
