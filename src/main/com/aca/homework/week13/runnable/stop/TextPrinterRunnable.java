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
