package com.aca.homework.week9.generic.queue;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super("Could not consume from the queue because it's empty.");
    }
}
