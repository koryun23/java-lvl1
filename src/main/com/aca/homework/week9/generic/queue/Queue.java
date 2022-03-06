package com.aca.homework.week9.generic.queue;

public class Queue<T> {
    private final Object[] elements = new Object[10_000];
    private int consumeIndex = 0;
    private int produceIndex = 0;
    public void produce(T object) {
        if (object == null) throw new IllegalArgumentException("Cannot add a null element to the queue");
        if(isEmpty()){
            produceIndex = 0;
            consumeIndex = 0;
        }
        elements[produceIndex++] = object;
    }

    public T consume() {
        if(isEmpty()) throw new QueueEmptyException();
        T elementToReturn = (T) elements[consumeIndex];
        elements[consumeIndex++] = null;
        return elementToReturn;
    }

    public boolean isEmpty(){
        return consumeIndex == produceIndex;
    }

    public int size(){
        return produceIndex - consumeIndex;
    }
}
