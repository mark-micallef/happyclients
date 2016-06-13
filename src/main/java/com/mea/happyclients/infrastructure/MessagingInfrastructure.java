package com.mea.happyclients.infrastructure;

import com.mea.happyclients.messages.Message;
import com.mea.happyclients.messages.TextMessage;
import com.rabbitmq.client.*;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

public class MessagingInfrastructure {

    //Messaging infrastructure
    ConnectionFactory connectionFactory;
    Connection connection;
    Channel channel;

    //Singleton Instance
    private static MessagingInfrastructure instance = null;


    private MessagingInfrastructure() {
        init();
    }

    public static MessagingInfrastructure getInstance() {
        if (instance == null) {
            instance = new MessagingInfrastructure();
        }

        return instance;
    }

    protected void init() {
        try {
            connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(Config.MESSAGING_HOST);
            connectionFactory.setPort(Config.MESSAGING_PORT);
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(Config.MESSAGING_QUEUE_NAME, false, false, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendTextMessage(TextMessage message) {
        boolean result = false;
        try {
            channel.basicPublish("", Config.MESSAGING_QUEUE_NAME, null, SerializationUtils.serialize(message));
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public void shutdown() {
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
