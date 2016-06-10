package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.users.User;
import com.mea.happyclients.users.UserDB;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestQueueManager {

    UserDB userDB;
    QueueManager queueManager;
    User user1;

    @Before
    public void setUp() {

        //Set up basic user database with test data
        userDB = new UserDB();
        user1 = new User("Sushi's Barber Shop");
        user1.addQueue("Barber 1");
        user1.addQueue("Barber 2");
        userDB.addUser(user1);

        assertEquals(0, user1.getQueueByName("Barber 1").getSize());
        assertEquals(0, user1.getQueueByName("Barber 2").getSize());

        //Instantiate QueueManager
        queueManager = new QueueManager(userDB);

    }

    public void populateQueues() {
        queueManager.addClientToQueue(user1.getId(), "Barber 1", new Client("John Doe", "35622626263"));
        queueManager.addClientToQueue(user1.getId(), "Barber 1", new Client("Jane Doe", "35622626263"));

        queueManager.addClientToQueue(user1.getId(), "Barber 2", new Client("Peppa Pig", "35622626263"));
        queueManager.addClientToQueue(user1.getId(), "Barber 2", new Client("Daddy Pig", "35622626263"));
        queueManager.addClientToQueue(user1.getId(), "Barber 2", new Client("Mummy Pig", "35622626263"));
        queueManager.addClientToQueue(user1.getId(), "Barber 2", new Client("Zoe Zebra", "35622626263"));
        queueManager.addClientToQueue(user1.getId(), "Barber 2", new Client("Danny Dog", "35622626263"));
    }

    @Test
    public void testAddClientToQueue() {

        populateQueues();

        assertEquals(2, user1.getQueueByName("Barber 1").getSize());
        assertEquals(5, user1.getQueueByName("Barber 2").getSize());
    }
}