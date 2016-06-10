package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;

import java.util.List;

/**
 * Symbolises the abstract notion of a queue.
 */
public interface Queue {

    QueueTypes getType();

    Client getNextClient();

    void addClient(Client client);

    List<Client> getOrderedListofClients();

}
