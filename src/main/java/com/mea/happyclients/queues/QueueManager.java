package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
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

        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i) + " is now in position " + i + " on the queue");
        }

        //Remove first client from the queue
        queue.getNextClient();

    }

}
