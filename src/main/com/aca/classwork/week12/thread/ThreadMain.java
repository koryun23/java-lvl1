package com.aca.classwork.week12.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newFixedThreadPool(16);

        System.out.println(System.currentTimeMillis());

        Thread[] threads = new Thread[16];
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 16; j++) {
                threads[j] = new Thread(new MyRunnable(i));
                threads[j].start();
            }
            for(int j = 0; j < 16; j++) {
                threads[j].join();
            }
        }
    }


    private static class MyRunnable implements Runnable {

        private final int number;

        public MyRunnable(int number) {
            this.number = number;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(System.currentTimeMillis());
        }
    }
}
