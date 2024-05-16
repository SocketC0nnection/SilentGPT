package net.socket.silentgpt.client;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.socket.silentgpt.SilentGPT;
import net.socket.silentgpt.managers.ConversationManager;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    private final Gson gson;
    private final java.net.http.HttpClient client;

    private final SilentGPT silentGPT;

    public HttpClient(SilentGPT silentGPT) {
        gson = new Gson();
        client = java.net.http.HttpClient.newHttpClient();

        this.silentGPT = silentGPT;
    }

    public String send(String question) {
        JsonObject object = new JsonObject();

        JsonArray messages;

        if(silentGPT.getRememberConversation()) {
            messages = silentGPT.getConversationManager().getMessages();

            silentGPT.getConversationManager().addMessage(ConversationManager.Role.USER, question);
        } else {
            messages = new JsonArray();

            JsonObject message = new JsonObject();

            message.addProperty("role", "user");
            message.addProperty("content", question);

            messages.add(message);
        }

        object.addProperty("model", "gpt-35-turbo");
        object.add("messages", messages);
        object.addProperty("stream", false);

        String text = "";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://aiforcause.deepnight.tech/openai/"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "SilentGPT by SocketConnection")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(object)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonReponse = gson.fromJson(response.body(), JsonObject.class);

            text = jsonReponse
                    .getAsJsonArray("choices")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString();

            silentGPT.getConversationManager().addMessage(ConversationManager.Role.ASSISTANT, text);
        } catch (Exception ignored) {}

        return text;
    }

    public SilentGPT getSilentGPT() {
        return silentGPT;
    }

    public java.net.http.HttpClient getClient() {
        return client;
    }

    public Gson getGson() {
        return gson;
    }
}
