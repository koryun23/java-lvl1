package com.aca.homework.week11.stopwatch;

public class WaitSeconds implements WaitingStrategy {
    @Override
    public void print(long startMillis) {

        System.out.println("Elapsed time: " + getElapsedTime(startMillis) + "s");
    }

    @Override
    public String getElapsedTime(long startMillis) {
        long elapsedTimeInMillis = System.currentTimeMillis() - startMillis;
        long seconds = elapsedTimeInMillis / 1000;
        return seconds < 10 ? "0" + seconds : Long.toString(seconds);
    }
}
