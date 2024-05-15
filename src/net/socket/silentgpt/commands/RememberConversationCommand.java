package net.socket.silentgpt.commands;

import net.socket.silentgpt.SilentGPT;

public class RememberConversationCommand extends Command {

    public RememberConversationCommand() {
        super("SILENTGPT_REMEMBER_CONVERSATION");
    }

    @Override
    public void onExecute() {
        SilentGPT.getInstance().setRememberConversation(!SilentGPT.getInstance().getRememberConversation());

        if(SilentGPT.getInstance().getRememberConversation()) {
            SilentGPT.getInstance().getConversationManager().reset();
        }
    }
}
