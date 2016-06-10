package com.mea.happyclients.clients;

/**
 * Embodies a client with whom the business wants to communicate.
 */
public class Client {

    protected String name;
    protected String mobileNumber;

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
}
