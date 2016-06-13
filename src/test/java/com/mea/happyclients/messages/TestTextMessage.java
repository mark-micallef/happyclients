package com.mea.happyclients.messages;

import com.mea.happyclients.infrastructure.Config;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTextMessage {

    TextMessage message;
    String senderID = "IgnoreThis";
    String mobileNumber = Config.MESSAGING_CMD_IGNORE;
    String messageText = "Hello there!!";

    @Before
    public void setUp(){
        message = new TextMessage(senderID, mobileNumber, messageText);
    }

    @Test
    public void testMessageType() {
        assertEquals(MessageTypes.TEXT, message.getMessageType());
    }

}
