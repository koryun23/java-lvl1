package com.aca.homework.week11.stopwatch;

public class StopWatch {
    private final ElapsedTimeStrategy elapsedTimeStrategy;

    public StopWatch(DisplayType type) {
        elapsedTimeStrategy = type == DisplayType.SECONDS ? new WaitSeconds() : new WaitSecondsAndMillis();
    }

    public static void sleep(long millis) {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < millis) ;
    }

    public void start() {
        long startMillis = System.currentTimeMillis();
        while (true) {
            sleep(10);
            elapsedTimeStrategy.print(startMillis);
        }
    }
}
