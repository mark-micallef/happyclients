package com.mea.happyclients.messages;


import com.mea.happyclients.clients.Client;
import com.mea.happyclients.queues.Queue;
import com.mea.happyclients.users.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageCreator {

    //Variables
    public static final String VAR_CLIENT_NAME = "%CLIENT_NAME%";
    public static final String VAR_USER_NAME = "%USER_NAME%";
    public static final String VAR_QUEUE_NAME = "%QUEUE_NAME%";
    public static final String VAR_POS_IN_QUEUE = "%POS_IN_QUEUE%";
    public static final String VAR_TIMESTAMP = "%TIMESTAMP%";

    public static final String DEFAULT_MESSAGE = "Dear " + VAR_CLIENT_NAME + ", as at " + VAR_TIMESTAMP + ", you are number "
            + VAR_POS_IN_QUEUE + " in the queue at " + VAR_USER_NAME + ".";

    public static final String DEFAULT_MESSAGE_YOUR_TURN = "Dear " + VAR_CLIENT_NAME + ", as at " + VAR_TIMESTAMP + ", it is your turn to be served at "
            + VAR_USER_NAME + ".";

    public String createMessage(String message, long timestamp, User user, Client client, Queue queue) {

        return message.replace(VAR_CLIENT_NAME, client.getName())
                .replace(VAR_USER_NAME, user.getName())
                .replace(VAR_QUEUE_NAME, queue.getName())
                .replace(VAR_TIMESTAMP, formatTimeStamp(timestamp))
                .replace(VAR_POS_IN_QUEUE, Integer.toString(queue.getClientPositionInQueue(client)))
                ;

    }

    public String formatTimeStamp(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("K:mm a");
        return sdf.format(new Date(timestamp));
    }

    public String createMessage(User user, long timestamp, Client client, Queue queue) {

        String message = DEFAULT_MESSAGE;

        if (queue.getClientPositionInQueue(client) == 0) {
            message = DEFAULT_MESSAGE_YOUR_TURN;
        }
        return createMessage(message, timestamp, user, client, queue);

    }

    public String createYourTurnMessage(User user, long timestamp, Client client, Queue queue) {
        return createMessage(DEFAULT_MESSAGE_YOUR_TURN, timestamp, user, client, queue);
    }
}
