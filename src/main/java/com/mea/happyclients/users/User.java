package com.mea.happyclients.users;

import com.mea.happyclients.queues.FifoQueue;
import com.mea.happyclients.queues.Queue;
import com.mea.happyclients.users.plans.Plan;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

/**
 * A user is a customer of Happy Clients and is typically a business that wants to
 * make its clients happier.
 */
public class User {

    protected String id = null;
    protected String name = null;
    protected String email = null;
    protected String senderID = null;
    protected Plan plan = null;
    protected HashMap<String, Queue> queues;

    public User() {

    }

    public User(String name) {
        setName(name);
        queues = new HashMap<>();
    }

    public String getName() {
        if (name == null) {
            name = "";
        }

        return name;
    }

    public String getSenderID() {
        if (senderID == null) {
            senderID = "HappyClient";
        }
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<String, Queue> getQueues() {
        return queues;
    }

    public Queue getQueueByName(String queueName) {
        return queues.get(queueName);
    }

    public void addQueue(String queueName) {
        queues.put(queueName, new FifoQueue(queueName));
    }

}
