package net.socket.silentgpt;

import net.socket.silentgpt.client.HttpClient;
import net.socket.silentgpt.commands.CloseCommand;
import net.socket.silentgpt.commands.NotificationCommand;
import net.socket.silentgpt.commands.RememberConversationCommand;
import net.socket.silentgpt.handlers.ClipboardUpdateHandler;
import net.socket.silentgpt.managers.ClipboardManager;
import net.socket.silentgpt.managers.CommandManager;
import net.socket.silentgpt.managers.ConversationManager;

public class SilentGPT {

    private static SilentGPT instance;

    private final ClipboardManager clipboardManager;
    private final CommandManager commandManager;
    private final ConversationManager conversationManager;

    private final HttpClient httpClient;

    private boolean notification;
    private boolean rememberConversation;

    public SilentGPT() {
        instance = this;

        clipboardManager = new ClipboardManager();
        commandManager = new CommandManager();
        conversationManager = new ConversationManager();
        httpClient = new HttpClient(this);

        commandManager.register(new CloseCommand());
        commandManager.register(new NotificationCommand());
        commandManager.register(new RememberConversationCommand());

        new ClipboardUpdateHandler(this).start();
    }

    public static void main(String[] args) {
        new SilentGPT();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public ConversationManager getConversationManager() {
        return conversationManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ClipboardManager getClipboardManager() {
        return clipboardManager;
    }

    public boolean getRememberConversation() {
        return rememberConversation;
    }

    public void setRememberConversation(boolean rememberConversation) {
        this.rememberConversation = rememberConversation;
    }

    public boolean getNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public static SilentGPT getInstance() {
        return instance;
    }
}
