package com.aca.homework.week11.stopwatch;

public class StopWatch {
    private final WaitingStrategy waitingStrategy;

    public StopWatch(DisplayType type) {
        waitingStrategy = type == DisplayType.SECONDS ? new WaitSeconds() : new WaitSecondsAndMillis();
    }

    public static void sleep(long millis) {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < millis) ;
    }

    public void start() {
        long startMillis = System.currentTimeMillis();
        while (true) {
            sleep(10);
            waitingStrategy.print(startMillis);
        }
    }
}
