package com.mea.happyclients.queues;

import com.mea.happyclients.clients.Client;
import com.mea.happyclients.infrastructure.MessagingInfrastructure;
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
        MessageCreator messageCreator = new MessageCreator();

        //Dequeue First Client and notify
        Client firstClient = queue.peakNextClient();
        TextMessage message = new TextMessage(user.getSenderID(), firstClient.getMobileNumber(), "");
        String messageText = messageCreator.createYourTurnMessage(user, message.getTimestamp(), firstClient, queue);
        message.setMessageText(messageText);
        msgInfrastructure.sendTextMessage(message);
        queue.dequeueNextClient();


        //Notify remaining clients
        List<Client> clients = queue.getOrderedListofClients();

        for (Client client : clients) {
            message = new TextMessage(user.getSenderID(), client.getMobileNumber(), messageText);
            messageText = messageCreator.createMessage(user, message.getTimestamp(), client, queue);
            message.setMessageText(messageText);

            msgInfrastructure.sendTextMessage(message);
        }


    }

    public void addClientToQueue(MessagingInfrastructure msgInfrastructure, User user, String queueName, Client client) {

        //Add user to queue
        user.getQueueByName(queueName).addClient(client);

        //Send text message
        MessageCreator messageCreator = new MessageCreator();
        TextMessage message = new TextMessage(user.getSenderID(), client.getMobileNumber(), "");
        String messageText = messageCreator.createMessage(user, message.getTimestamp(), client, user.getQueueByName(queueName));
        message.setMessageText(messageText);

        msgInfrastructure.sendTextMessage(message);
    }

}
