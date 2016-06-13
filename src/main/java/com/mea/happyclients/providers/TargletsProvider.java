package com.mea.happyclients.providers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mea.happyclients.clients.Client;
import com.mea.happyclients.messages.Message;
import com.mea.happyclients.messages.TextMessage;

/**
 * Implements interactions with the Targlets service
 */
public class TargletsProvider implements Provider {

    private final static String API_KEY = "79c4ad53-206b-4d3a-be75-e3c78eec4510";
    private final static String RATE_ID = "5d6be126-5ad8-4caa-b79a-b073fdf427de";

    public void sendMessage(TextMessage message) {

        try {
            HttpResponse<String> response = Unirest.post("https://targlets.com/api/Send")
                    .field("apikey", API_KEY)
                    .field("recipients", message.getMobileNumber())
                    .field("senderid", "HappyClients")
                    .field("message", message.getMessageText())
                    .field("type", "0")
                    .field("rateid", RATE_ID)
                    .asString();
        } catch (UnirestException une) {
            une.printStackTrace();
        }

    }

}
