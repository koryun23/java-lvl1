package com.aca.classwork.week13.interrupt;

public class InterruptMain {
    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            doHeavyTasks();
            System.out.println("Finished");
        });
        thread.start();

        new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt(); // to stop the thread // not a good way of interrupting a thread.

        }).start();

    }

    public static void doHeavyTasks(){
        for(int i = 0; i < 100; i++) {
            if(Thread.interrupted()) {
                return;
            }
            System.out.println("Doing a heavy task - " + i);
            long startMillis = System.currentTimeMillis();
            while(System.currentTimeMillis() - startMillis < 100) ;

        }
    }
}
