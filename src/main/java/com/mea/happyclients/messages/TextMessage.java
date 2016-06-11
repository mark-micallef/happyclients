package com.mea.happyclients.messages;


import com.mea.happyclients.clients.Client;
import com.mea.happyclients.users.User;

/**
 * Encapsulates the notion of a text message.
 */

public class TextMessage implements Message {

    protected User user = null;
    protected Client client = null;
    protected String messageText;

    public TextMessage(User user, Client client, String messageText) {
        this(messageText);
        this.user = user;
        this.client = client;
    }

    public TextMessage(String messageText) {
        setMessageText(messageText);
    }

    public MessageTypes getMessageType() { return MessageTypes.TEXT; }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

}
