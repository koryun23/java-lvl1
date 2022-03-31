package com.aca.homework.week12.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            customThreadCreationSolution();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void customThreadCreationSolution() throws InterruptedException {
        System.out.println("Started");
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis());
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Finished");
    }

    public static void executorSolution() throws InterruptedException {
        System.out.println("Started");
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis());
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(task);
        executor.execute(task);

        executor.shutdown();

        while(!executor.isTerminated());

        System.out.println("Finished");
    }
}
