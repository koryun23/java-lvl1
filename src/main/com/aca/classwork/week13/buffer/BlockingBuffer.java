package com.aca.classwork.week13.buffer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer<T> implements Buffer<T>{

    private ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<>(1);

    @Override
    public T get() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void put(T value) throws InterruptedException {
        queue.put(value);
    }
}
