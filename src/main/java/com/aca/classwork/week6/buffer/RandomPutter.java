package com.aca.classwork.week6.buffer;

import java.util.Scanner;

public class RandomPutter {
    private final Buffer buffer;

    public RandomPutter(Buffer buffer) {
        this.buffer = buffer;
    }

    public static void wait1Second() {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) / 1000 < 1) {
        }
    }

    public static void main(String[] args) {

        Buffer buffer = getBuffer();

        RandomPutter randomPutter = new RandomPutter(buffer);
        randomPutter.start();
    }

    public static Buffer getBuffer() {
        System.out.println("Enter 0 if you want to use string buffer, 1 if you want to use array buffer");
        int number = new Scanner(System.in).nextInt();
        if (number == 0) {
            return new MyBuffer();
        } else if (number == 1) {
            return new ArrayBuffer();
        } else {
            throw new IllegalArgumentException("input must be 0 or 1 ");
        }
    }

    public void start() {
        for (int i = 0; i < 6; i++) {
            wait1Second();
            buffer.put("text " + i);
            wait1Second();
            System.out.println(buffer.get());
        }
    }

}
