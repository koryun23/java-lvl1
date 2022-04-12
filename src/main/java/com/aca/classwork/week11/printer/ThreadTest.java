package com.aca.classwork.week11.printer;

public class ThreadTest {
    public static void main(String[] args) {
        createThreads();
    }

    public static void createThreads(){
        for(int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long startMillis = System.currentTimeMillis();
                    while(System.currentTimeMillis() - startMillis < 1000);
                }
            }).start();
        }
    }
}
