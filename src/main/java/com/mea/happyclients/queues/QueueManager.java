package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.infrastructure.MessagingInfrastructure;
import com.mea.happyclients.messages.Message;
import com.mea.happyclients.messages.MessageCreator;
import com.mea.happyclients.messages.TextMessage;
import com.mea.happyclients.users.User;
import com.mea.happyclients.users.UserDB;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.List;

/**
 * Manages queues for multiple users of the system.  Each user can have multiple
 * queues. For example, a queue for each barber in a barber shop.
 */

public class QueueManager {

    UserDB userDB;

    //Messaging infrastructure
    /*ConnectionFactory connectionFactory;
    Connection connection;
    Channel channel;*/

    public QueueManager(UserDB userDB) {
        this.userDB = userDB;

        //Initialise messaging infrastructure
        /*connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();
        channel = connectionFactory.createChannel();*/
    }

    public void advanceQueue(MessagingInfrastructure msgInfrastructure, String userID, String queueName) {
        User user = userDB.getUserByID(userID);
        Queue queue = user.getQueueByName(queueName);
        List<Client> clients = queue.getOrderedListofClients();

        MessageCreator messageCreator = new MessageCreator();

        for (Client client : clients) {
            String messageText = messageCreator.createMessage(user, client, queue);
            TextMessage message = new TextMessage(client.getMobileNumber(), messageText);
            msgInfrastructure.getInstance().sendTextMessage(message);
        }

        //Remove first client from the queue
        queue.getNextClient();
    }

    public void addClientToQueue(String userID, String queueName, Client client) {
        userDB.getUserByID(userID).getQueueByName(queueName).addClient(client);
    }

}
