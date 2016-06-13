package com.mea.happyclients.clients;

import com.mea.happyclients.queues.Queue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

/**
 * Embodies a client with whom the business wants to communicate.
 */
public class Client {

    protected String name;
    protected String mobileNumber;

    public Client(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String toString() {
        return name;
    }

}
