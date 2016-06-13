package com.mea.happyclients.messages;


import com.mea.happyclients.clients.Client;
import com.mea.happyclients.users.User;

import java.io.Serializable;

/**
 * Encapsulates the notion of a text message.
 */

public class TextMessage implements Message, Serializable {

    protected String mobileNumber;
    protected String messageText;

    public TextMessage(String mobileNumber, String messageText) {
        this.mobileNumber = mobileNumber;
        this.messageText = messageText;
    }


    public MessageTypes getMessageType() { return MessageTypes.TEXT; }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }


}
