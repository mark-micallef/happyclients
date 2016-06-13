package com.mea.happyclients.messages;


import com.mea.happyclients.clients.Client;
import com.mea.happyclients.queues.Queue;
import com.mea.happyclients.users.User;

public class MessageCreator {

    //Variables
    public static final String VAR_CLIENT_NAME = "%CLIENT_NAME%";
    public static final String VAR_USER_NAME = "%USER_NAME%";
    public static final String VAR_QUEUE_NAME = "%QUEUE_NAME%";
    public static final String VAR_POS_IN_QUEUE = "%POS_IN_QUEUE%";

    public static final String DEFAULT_MESSAGE = "Dear " + VAR_CLIENT_NAME + ", you are now number "
            + VAR_POS_IN_QUEUE + " in the queue at " + VAR_USER_NAME + ".";

    public static final String DEFAULT_MESSAGE_YOUR_TURN = "Dear " + VAR_CLIENT_NAME + ", it is your turn to be served."
            + " at " + VAR_USER_NAME + ".";

    public String createMessage(String message, User user, Client client, Queue queue) {

        return message.replace(VAR_CLIENT_NAME, client.getName())
                .replace(VAR_USER_NAME, user.getName())
                .replace(VAR_QUEUE_NAME, queue.getName())
                .replace(VAR_POS_IN_QUEUE, Integer.toString(queue.getClientPositionInQueue(client))
                );

    }

    public String createMessage(User user, Client client, Queue queue) {

        String message = DEFAULT_MESSAGE;

        if (queue.getClientPositionInQueue(client) == 0) {
            message = DEFAULT_MESSAGE_YOUR_TURN;
        }
        return createMessage(message, user, client, queue);

    }
}
