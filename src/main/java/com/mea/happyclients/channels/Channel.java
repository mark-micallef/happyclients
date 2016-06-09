package com.mea.happyclients.channels;

import com.mea.happyclients.messages.Message;

/**
 * Encapsulates the notion of a channel over which messages can be sent.
 */
public interface Channel {

    ChannelTypes getChannelType();

    void sendMessage(Message message);

}
