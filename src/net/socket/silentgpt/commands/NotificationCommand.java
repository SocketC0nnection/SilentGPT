package net.socket.silentgpt.commands;

import net.socket.silentgpt.SilentGPT;

public class NotificationCommand extends Command {

    public NotificationCommand() {
        super("SILENTGPT_NOTIFY");
    }

    @Override
    public void onExecute() {
        SilentGPT.getInstance().setNotification(!SilentGPT.getInstance().getNotification());
    }

}
