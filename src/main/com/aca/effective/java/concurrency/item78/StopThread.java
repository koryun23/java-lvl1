package com.aca.effective.java.concurrency.item78;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
    // the backgroundThread loops forever
    // The problem is that in the absence of synchronization, there is no guarantee as to when, if ever, the background thread
    // will see the change in the value of stopRequested made by the main thread. In the absence of synchronization the JVM
    // might even transform the code of the run() method to the code of possibleTransformation() method.
    // This optimization is called hoisting.

    private void possibleTransormation() {
        int i = 0;
        if(!stopRequested) {
            while(true) {
                i++;
            }
        }
    }
}
