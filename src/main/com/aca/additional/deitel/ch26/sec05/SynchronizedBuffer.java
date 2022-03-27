package com.aca.additional.deitel.ch26.sec05;

public class SynchronizedBuffer implements Buffer{
    private int buffer = -1;
    private boolean occupied = false;

    @Override
    public synchronized void set(int value) throws InterruptedException {
        while(occupied) {
            System.out.println("Producer tries to write");
            System.out.println("Buffer is full. Producer waits");
            wait();
        }

        buffer = value;
        occupied = true;

        System.out.println("Producer writes " + buffer);

        notifyAll();
    }

    @Override
    public synchronized int get() throws InterruptedException {
        while (!occupied) {
            System.out.println("Consumer tries to read");
            System.out.println("Buffer is empty. Consumer waits");
            wait();
        }

        occupied = false;
        System.out.println("Consumer reads " + buffer);

        notifyAll();

        return buffer;
    }
}
