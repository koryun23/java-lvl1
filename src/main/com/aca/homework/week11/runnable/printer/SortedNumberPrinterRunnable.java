package com.aca.homework.week11.runnable.printer;

import java.util.Random;

public class SortedNumberPrinterRunnable implements Runnable {

    private final int waitingTime;
    private final int number;

    public SortedNumberPrinterRunnable(int number) {
        waitingTime = new Random().nextInt(190) + 10;
        this.number = number;
    }

    @Override
    public void run() {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < waitingTime) ;
        System.out.println(number);
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}
