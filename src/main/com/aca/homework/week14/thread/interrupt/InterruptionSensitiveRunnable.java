package com.aca.homework.week14.thread.interrupt;

import java.util.List;
import java.util.UUID;

public class InterruptionSensitiveRunnable implements Runnable {

    private final List<String> sharedList;

    public InterruptionSensitiveRunnable(List<String> sharedList) {
        this.sharedList = sharedList;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            sharedList.add(UUID.randomUUID().toString());
        }
    }
}