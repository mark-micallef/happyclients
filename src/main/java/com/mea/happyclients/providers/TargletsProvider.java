package com.mea.happyclients.providers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mea.happyclients.clients.Client;
import com.mea.happyclients.messages.Message;

/**
 * Implements interactions with the Targlets service
 */
public class TargletsProvider implements Provider {

    public void sendMessage(Client client, Message message) {

        try {
            HttpResponse<String> response = Unirest.post("https://targlets.com/api/Send")
                    .field("apikey", "79c4ad53-206b-4d3a-be75-e3c78eec4510")
                    .field("recipients", "35679251928")
                    .field("senderid", "WhoKnows")
                    .field("message", "Hello... Notifica.")
                    .field("type", "1")
                    .field("rateid", "5d6be126-5ad8-4caa-b79a-b073fdf427de")
                    .asString();
        } catch (UnirestException une) {
            une.printStackTrace();
        }

    }

}
