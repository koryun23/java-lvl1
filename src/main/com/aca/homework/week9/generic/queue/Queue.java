package com.aca.homework.week9.generic.queue;

public class Queue<T> {
    private final Object[] elements = new Object[10_000];
    private int produceIndex = 0;

    public void produce(T object) {
        if (object == null) throw new IllegalArgumentException("Cannot add a null element to the queue");
        elements[produceIndex++] = object;
    }

    public T consume() {
        if (isEmpty()) throw new QueueEmptyException();
        T elementToReturn = (T) elements[0];
        elements[0] = null;
        leftShift(); // as the first element of the queue is consumed, we need to shift all the elements to the left
        return elementToReturn;
    }

    public boolean isEmpty() {
        return produceIndex == 0;
    }

    public int size() {
        return produceIndex;
    }

    public void leftShift() {
        for (int i = 1; i < produceIndex; i++) {
            elements[i - 1] = elements[i];
        }
        elements[produceIndex - 1] = null;
        produceIndex--;
    }
}
