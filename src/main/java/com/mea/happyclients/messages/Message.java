package com.mea.happyclients.messages;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.users.User;

/**
 * This interface provides methods with all messages should implement.
 */
public interface Message {

    MessageTypes getMessageType();
    String getMessageText();

}
