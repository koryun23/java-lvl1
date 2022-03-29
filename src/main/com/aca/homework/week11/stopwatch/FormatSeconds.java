package com.aca.homework.week11.stopwatch;

public class FormatSeconds implements FormatTimeStrategy {

    @Override
    public String formatElapsedTime(long startMillis) {
        long elapsedTimeInMillis = System.currentTimeMillis() - startMillis;
        long seconds = elapsedTimeInMillis / 1000;
        return seconds < 10 ? "0" + seconds : Long.toString(seconds);
    }
}
