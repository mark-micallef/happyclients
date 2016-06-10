package com.mea.happyclients.channels;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.messages.Message;

/**
 * Encapsulates an SMS channel which delivers messages over a short messaging service.
 */
public class SMSChannel implements Channel {

    public ChannelTypes getChannelType() {
        return ChannelTypes.SMS;
    }

    public void sendMessage(Client client, Message message) {

    }
}
