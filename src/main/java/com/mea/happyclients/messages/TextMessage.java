package com.mea.happyclients.messages;


import java.io.Serializable;

/**
 * Encapsulates the notion of a text message.
 */

public class TextMessage implements Message, Serializable {

    protected String senderID;
    protected String mobileNumber;
    protected String messageText;

    public TextMessage(String senderID, String mobileNumber, String messageText) {
        this.senderID = senderID;
        this.mobileNumber = mobileNumber;
        this.messageText = messageText;
    }


    public MessageTypes getMessageType() {
        return MessageTypes.TEXT;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


}
