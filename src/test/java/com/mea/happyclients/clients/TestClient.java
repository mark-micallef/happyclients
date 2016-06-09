package com.mea.happyclients.clients;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClient {

    Client client;

    @Before
    public void setUp() {
        client = new Client();
    }

    @Test
    public void testNameGettersAndSetters() {
        String name = "Elaine Grech";
        client.setName(name);
        assertEquals(name, client.getName());
    }

}
