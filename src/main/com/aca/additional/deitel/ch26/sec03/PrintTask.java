package com.aca.additional.deitel.ch26.sec03;

import java.util.Random;

public class PrintTask implements Runnable{

    private final int sleepTime;
    private final String taskName;
    private static final Random generator = new Random();

    public PrintTask(String taskName) {
        this.sleepTime = generator.nextInt(5000);
        this.taskName = taskName;

    }

    @Override
    public void run() {
        try {
            System.out.printf("%s going to sleep for %d milliseconds.\n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        } catch(InterruptedException e) {
            System.out.printf("%s terminated prematurely due to interruption.\n", taskName);
        }

        System.out.printf("%s done sleeping.\n", taskName);
    }
}
