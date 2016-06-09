package com.mea.happyclients.channels;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSMSChannel {

    SMSChannel channel;

    @Before
    public void setUp() {
        channel = new SMSChannel();
    }

    @Test
    public void testChannelType() {
        assertEquals(ChannelTypes.SMS, channel.getChannelType());
    }

}
