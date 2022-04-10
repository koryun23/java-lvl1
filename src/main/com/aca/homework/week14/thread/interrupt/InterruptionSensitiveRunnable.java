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
        while (true) {
            if (Thread.interrupted())
                return;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (Thread.interrupted())
                return;

            synchronized (sharedList) {
                sharedList.add(UUID.randomUUID().toString());
            }
        }
    }
}
