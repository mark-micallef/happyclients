package com.mea.happyclients.clients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClient {

    Client client;
    String clientName = "John Doe";
    String clientMobileNumber = "356123456";

    @Before
    public void setUp() {
        client = new Client(clientName, clientMobileNumber);
    }

    @Test
    public void testNameGettersAndSetters() {
        String name = "Elaine Grech";
        client.setName(name);
        assertEquals(name, client.getName());
    }

}
