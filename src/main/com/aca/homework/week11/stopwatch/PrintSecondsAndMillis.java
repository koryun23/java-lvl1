package com.aca.homework.week11.stopwatch;

public class PrintSecondsAndMillis implements PrintTimeStrategy {
    @Override
    public void print(long startMillis, String formattedElapsedTime) {
        System.out.println("Elapsed time: " + formattedElapsedTime);
    }
}
