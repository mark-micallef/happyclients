package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a FIFO queue
 */
public class FifoQueue implements Queue {

    List<Client> clients;
    String name;

    public FifoQueue(String name) {
        this.name = name;
        clients = new ArrayList<>();
    }

    public QueueTypes getType() {
        return QueueTypes.FIFO;
    }

    @Override
    public Client getNextClient() {

        Client client = null;

        if (clients.size() > 0) {
            client = clients.get(0);
            clients.remove(0);
        }

        return client;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return clients.size();
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public List<Client> getOrderedListofClients() {
        return clients;
    }

    @Override
    public int getClientPositionInQueue(Client client) {
        return clients.indexOf(client);
    }
}
