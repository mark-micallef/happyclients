package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.messages.Message;
import com.mea.happyclients.messages.MessageCreator;
import com.mea.happyclients.messages.TextMessage;
import com.mea.happyclients.users.User;
import com.mea.happyclients.users.UserDB;

import java.util.List;

/**
 * Manages queues for multiple users of the system.  Each user can have multiple
 * queues. For example, a queue for each barber in a barber shop.
 */

public class QueueManager {

    UserDB userDB;

    public QueueManager(UserDB userDB) {
        this.userDB = userDB;
    }

    public void advanceQueue(String userID, String queueName) {
        User user = userDB.getUserByID(userID);
        Queue queue = user.getQueueByName(queueName);
        List<Client> clients = queue.getOrderedListofClients();

        MessageCreator messageCreator = new MessageCreator();

        for (Client client : clients) {
            String messageText = messageCreator.createMessage(user, client, queue);
            TextMessage message = new TextMessage(user, client, messageText);


        }

        System.out.println("----------");

        //Remove first client from the queue
        queue.getNextClient();
    }

    public void addClientToQueue(String userID, String queueName, Client client) {
        userDB.getUserByID(userID).getQueueByName(queueName).addClient(client);
    }

}
