package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestFifoQueue {

    FifoQueue queue;
    String queueName = "my-queue";

    @Before
    public void setUp() {
        queue = new FifoQueue(queueName);
        assertEquals(0, queue.getSize());
    }

    @Test
    public void testQueueType() {
        assertEquals(QueueTypes.FIFO, queue.getType());
    }

    @Test
    public void testQueueName() {
        assertEquals(queueName, queue.getName());
    }

    @Test
    public void testQueueSizeAfterOneAdd() {
        queue.addClient(new Client("John Doe", "35612341234"));
        assertEquals(1, queue.getSize());
    }

    @Test
    public void testQueueSizeAfterFiveAdds() {
        queue.addClient(new Client("John Doe", "35612341234"));
        queue.addClient(new Client("John Doe", "35612341234"));
        queue.addClient(new Client("John Doe", "35612341234"));
        queue.addClient(new Client("John Doe", "35612341234"));
        queue.addClient(new Client("John Doe", "35612341234"));
        assertEquals(5, queue.getSize());
    }

    @Test
    public void testQueueSizeChangeAfterGetNext() {
        Client client = new Client("John Doe", "35612341234");
        queue.addClient(client);
        queue.addClient(new Client("Jane Doe", "35612341234"));
        queue.addClient(new Client("Jimmy Doe", "35612341234"));

        assertEquals(3, queue.getSize());
        assertEquals(client, queue.getNextClient());
        assertEquals(2, queue.getSize());
    }

    @Test
    public void testNextClientOnEmptyQueue() {
        assertEquals(null, queue.getNextClient());
        assertEquals(0, queue.getSize());
    }


}
