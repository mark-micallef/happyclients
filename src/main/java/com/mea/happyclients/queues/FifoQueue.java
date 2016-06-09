package com.mea.happyclients.queues;

/**
 * Created by markmicallef on 09/06/2016.
 */
public class FifoQueue implements Queue {


    public QueueTypes getType() {
        return QueueTypes.FIFO;
    }
}
