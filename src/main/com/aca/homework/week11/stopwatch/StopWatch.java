package com.aca.homework.week11.stopwatch;

public class StopWatch {
    private final FormatTimeStrategy formatTimeStrategy;
    private final PrintTimeStrategy printTimeStrategy;

    public StopWatch(DisplayType type) {
        formatTimeStrategy = type.getFormatTimeStrategy();
        printTimeStrategy = type.getPrintTimeStrategy();
    }

    public void start() throws InterruptedException {
        long startMillis = System.currentTimeMillis();
        while (true) {
            Thread.sleep(10);
            printTimeStrategy.print(startMillis, formatTimeStrategy.formatElapsedTime(startMillis));
        }
    }
}
