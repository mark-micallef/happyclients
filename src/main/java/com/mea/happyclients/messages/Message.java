package com.mea.happyclients.messages;

/**
 * This interface provides methods with all messages should implement.
 */
public interface Message {

    MessageTypes getMessageType();

    String getMessageText();

}
