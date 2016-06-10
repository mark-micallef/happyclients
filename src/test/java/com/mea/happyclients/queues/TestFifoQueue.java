package com.mea.happyclients.queues;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestFifoQueue {

    FifoQueue queue;
    String queueName = "my-queue";

    @Before
    public void setUp() {
        queue = new FifoQueue(queueName);
    }

    @Test
    public void testQueueType() {
        assertEquals(QueueTypes.FIFO, queue.getType());
    }
}
