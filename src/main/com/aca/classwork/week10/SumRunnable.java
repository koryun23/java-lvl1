package com.aca.classwork.week10;

public class SumRunnable implements Runnable {
    private final int num1;
    private final int num2;

    public SumRunnable(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println(add2Numbers());
    }

    public int add2Numbers() {
        return num1 + num2;
    }
}
