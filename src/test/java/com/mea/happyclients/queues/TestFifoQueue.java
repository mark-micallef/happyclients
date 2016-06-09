package com.mea.happyclients.queues;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by markmicallef on 09/06/2016.
 */
public class TestFifoQueue {

    FifoQueue queue;

    @Before
    public void setUp() {
        queue = new FifoQueue();
    }

    @Test
    public void testQueueType() {
        assertEquals(QueueTypes.FIFO, queue.getType());
    }
}
