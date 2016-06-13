package com.mea.happyclients;

import com.mea.happyclients.infrastructure.MessagingInfrastructure;
import com.mea.happyclients.providers.TargletsProvider;

/**
 * Listens to a Queue for messages and sends them accordingly
 */
public class MessageProcessor {


    public static void main(String[] args) {
        MessagingInfrastructure.getInstance().receiveLoop();

    }


}
