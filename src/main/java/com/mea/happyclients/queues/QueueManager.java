package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.users.User;
import com.mea.happyclients.users.UserDB;

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

    }

}
