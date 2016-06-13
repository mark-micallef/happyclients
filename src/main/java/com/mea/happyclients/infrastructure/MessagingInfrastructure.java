package com.mea.happyclients.infrastructure;

import com.mea.happyclients.messages.TextMessage;
import com.mea.happyclients.providers.TargletsProvider;
import com.rabbitmq.client.*;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

public class MessagingInfrastructure {

    //Singleton Instance
    private static MessagingInfrastructure instance = null;

    //Messaging infrastructure
    ConnectionFactory connectionFactory;
    Connection connection;
    Channel channel;

    //Control Variables
    boolean exit = false;


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

    public void receiveLoop() {
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                TextMessage message = (TextMessage) SerializationUtils.deserialize(body);
                TargletsProvider provider = new TargletsProvider();
                if (!message.getMobileNumber().equals(Config.MESSAGING_SHUTDOWN_CMD)) {
                    //System.out.println(" [x] I was asked to send a message to " + message.getMobileNumber() + " (" + message.getMessageText() + ")");
                    if (!message.getMobileNumber().equals(Config.MESSAGING_CMD_IGNORE)) {
                        provider.sendMessage(message);
                    }
                } else {
                    exit = true;
                }
            }
        };

        System.out.println("Waiting for messages");

        try {
            while (!exit) {
                channel.basicConsume(Config.MESSAGING_QUEUE_NAME, true, consumer);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Receive loop shutting down");
        MessagingInfrastructure.getInstance().shutdown();
        System.out.println("Shutdown complete!!");
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
