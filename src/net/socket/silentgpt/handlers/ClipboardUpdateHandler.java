package net.socket.silentgpt.handlers;

import net.socket.silentgpt.SilentGPT;
import net.socket.silentgpt.commands.Command;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClipboardUpdateHandler {

    private final SilentGPT silentGPT;
    private String lastClipboardText;

    public ClipboardUpdateHandler(SilentGPT silentGPT) {
        this.silentGPT = silentGPT;

        lastClipboardText = "";

        silentGPT.getClipboardManager().setClipboardText(lastClipboardText);
    }

    public void start() {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                String newClipboardText = silentGPT.getClipboardManager().getClipboardText();

                if(lastClipboardText.equals(newClipboardText)) {
                    return;
                }

                Command command = silentGPT.getCommandManager().getCommand(newClipboardText.trim());

                if(command != null) {
                    command.onExecute();

                    silentGPT.getClipboardManager().setClipboardText(lastClipboardText);

                    return;
                }

                if(silentGPT.isStandby()) {
                    return;
                }

                lastClipboardText = newClipboardText;

                String answer = silentGPT.getHttpClient().send(newClipboardText);

                lastClipboardText = answer;
                silentGPT.getClipboardManager().setClipboardText(answer);

                if(!silentGPT.getNotification()) {
                    return;
                }

                Toolkit.getDefaultToolkit().beep();
            }

        }, 0, 1000);
    }

    public String getLastClipboardText() {
        return lastClipboardText;
    }

    public SilentGPT getSilentGPT() {
        return silentGPT;
    }
}
