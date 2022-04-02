package com.aca.homework.week13.runnable.stop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextPrinterMain {
    public static void main(String[] args) {
        TextPrinterRunnable textPrinterRunnable = new TextPrinterRunnable((s) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }, "HELLO WORLD");
        new Thread(textPrinterRunnable).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        textPrinterRunnable.stop();


    }
}
