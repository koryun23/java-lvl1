package com.aca.classwork.week12;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Timer {

    private boolean isRunning = true;

    public static void main(String[] args) throws FileNotFoundException {
        System.setErr(new PrintStream("src\\main\\com\\aca\\classwork\\week12\\file.txt"));

        Timer timer1 = new Timer();
        timer1.start();

        Timer timer2 = new Timer();
        timer2.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input a number");
            final int number = scanner.nextInt();
            if (number == -1) {
                timer1.stop();
                timer2.stop();
                break;
            }
        }
    }

    public synchronized void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (isRunning) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println(i++);
                }
            }
        }).start();
    }

    public synchronized void stop() {
        isRunning = false;
    }
}
