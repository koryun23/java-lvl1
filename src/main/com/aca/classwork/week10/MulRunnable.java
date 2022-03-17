package com.aca.classwork.week10;

public class MulRunnable implements Runnable {
    private final int num1;
    private final int num2;

    public MulRunnable(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        System.out.println(multiply2Numbers());
    }

    public int multiply2Numbers() {
        return num1 * num2;
    }
}