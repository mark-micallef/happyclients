package com.mea.happyclients.users;

import com.mea.happyclients.queues.Queue;

import java.util.HashMap;
import java.util.UUID;

/**
 * A user is a customer of Happy Clients and is typically a business that wants to
 * make its clients happier.
 */
public class User {

    protected String id;
    protected String name;
    protected HashMap<String, Queue> queues;

    public User(String name) {
        id = UUID.randomUUID().toString();
        setName(name);

        queues = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Queue> getQueues() {
        return queues;
    }

    public Queue getQueueByName(String queueName) {
        return queues.get(queueName);
    }

}
