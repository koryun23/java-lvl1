package com.aca.homework.week13.runnable.stop;


import java.util.function.Consumer;

public class TextPrinterRunnable implements Runnable {

    private final Consumer<String> consumer;
    private final String text;
    private volatile boolean isRunning = true;

    public TextPrinterRunnable(final Consumer<String> consumer, final String text) {
        this.consumer = consumer;
        this.text = text;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consumer.accept(text);
        }
    }

    public void stop() {
        isRunning = false;
    }

    public String getPrintedText(){
        return text;
    }
}
