package com.aca.homework.week11.runnable.printer;

public class NumberPrinterRunnable implements Runnable {
    private final int number;

    public NumberPrinterRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < 1000) ;
        System.out.println(number);
    }
}
