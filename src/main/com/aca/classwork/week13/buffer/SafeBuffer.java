package com.aca.classwork.week13.buffer;

public final class SafeBuffer<T> implements Buffer<T> {

    private T value;

    @Override
    public synchronized T get() throws InterruptedException {
        while (value == null) {
            wait();
        }
        T valueToReturn = value;
        value = null;
        notifyAll();
        return valueToReturn;
    }

    @Override
    public synchronized void put(final T t) throws InterruptedException {
        while (value != null) {
            wait();
        }
        this.value = t;
        notifyAll();
    }

    public static void main(String[] args) {
        final Buffer<Integer> buffer = new BlockingBuffer<>();

        for(int i = 0; i < 1000; i++) {
            final int finalI = i;
            Runnable getRunnable = () -> {
                try {
                    buffer.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(getRunnable).start();
        }

        for(int i = 0; i < 1000; i++ ) {
            Runnable putRunnable = () -> {
                try {
                    System.out.println("Printing " + buffer.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(putRunnable).start();
        }
    }
}

