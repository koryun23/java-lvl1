package com.aca.classwork.week12.threadtask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static synchronized void increment(int[] a) {
        a[0]++;
    }

    public static void main(String[] args) throws InterruptedException {
        final int[] a = {0};
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    increment(a);
                }
            }));
            threads.get(i).start();
        }
        threads.forEach(new Consumer<Thread>() {
            @Override
            public void accept(Thread thread) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(a[0]);
    }
}
