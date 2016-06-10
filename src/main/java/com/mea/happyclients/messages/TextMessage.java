package com.mea.happyclients.messages;


/**
 * Encapsulates the notion of a text message.
 */

public class TextMessage implements Message {

    protected String messageText;

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
