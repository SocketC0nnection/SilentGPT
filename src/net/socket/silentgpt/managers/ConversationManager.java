package net.socket.silentgpt.managers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ConversationManager {

    private JsonArray messages;

    public ConversationManager() {
        messages = new JsonArray();
    }

    public JsonObject addMessage(Role role, String content) {
        JsonObject message = new JsonObject();

        message.addProperty("role", role.getName());
        message.addProperty("content", content);

        messages.add(message);

        return message;
    }

    public void reset() {
        messages = new JsonArray();
    }

    public JsonArray getMessages() {
        return messages;
    }

    public enum Role {

        USER("user"),
        ASSISTANT("assistant");

        private final String name;

        Role(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
