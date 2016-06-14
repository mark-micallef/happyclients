package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;

import java.util.List;

/**
 * Symbolises the abstract notion of a queue.
 */
public interface Queue {

    QueueTypes getType();

    Client dequeueNextClient();

    Client peakNextClient();

    void addClient(Client client);

    List<Client> getOrderedListofClients();

    int getClientPositionInQueue(Client client);

    String getName();

    int getSize();

}
