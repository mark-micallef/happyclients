package com.mea.happyclients.messages;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTextMessage {

    TextMessage message;
    String messageText = "Hello there!!";

    @Before
    public void setUp(){
        message = new TextMessage(messageText);
    }

    @Test
    public void testMessageType() {
        assertEquals(MessageTypes.TEXT, message.getMessageType());
    }

}
