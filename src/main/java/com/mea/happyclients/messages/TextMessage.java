package com.mea.happyclients.messages;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Encapsulates the notion of a text message.
 */

public class TextMessage implements Message, Serializable {

    protected long timestamp;
    protected String senderID;
    protected String mobileNumber;
    protected String messageText;

    public TextMessage(String senderID, String mobileNumber, String messageText) {
        this.senderID = senderID;
        this.mobileNumber = mobileNumber;
        this.messageText = messageText;
        this.timestamp = System.currentTimeMillis();
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

    public long getTimestamp() {
        return timestamp;
    }

    public String getFormattedTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("K:mm a");
        return sdf.format(new Date(getTimestamp()));
    }


}
