package com.aca.additional.deitel.ch26.sec04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(6);
        Runnable arrayWriter1 = new ArrayWriter(1, simpleArray);
        Runnable arrayWriter2 = new ArrayWriter(11, simpleArray);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(arrayWriter1);
        executor.execute(arrayWriter2);

        executor.shutdown();

        try {
            boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

            if(tasksEnded) {
                System.out.println(simpleArray);
            } else {
                System.out.println("Timed out while waiting for the tasks to end");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for tasks to finish.");
        }
    }
}
