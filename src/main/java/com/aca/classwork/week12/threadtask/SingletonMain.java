package com.aca.classwork.week12.threadtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingletonMain {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 2000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Singleton.getInstance().hashCode());
                }
            });
            threads.add(thread);
            thread.start();
        }
    }
}
