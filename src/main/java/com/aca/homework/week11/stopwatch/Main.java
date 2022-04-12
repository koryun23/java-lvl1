package com.aca.homework.week11.stopwatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch(DisplayType.SECONDS_AND_MILLIS);
        stopWatch.start();
    }
}
