package com.mea.happyclients.messages;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTextMessage {

    TextMessage message;

    @Before
    public void setUp(){
        message = new TextMessage();
    }

    @Test
    public void testMessageType() {
        assertEquals(MessageTypes.TEXT, message.getMessageType());
    }

}
