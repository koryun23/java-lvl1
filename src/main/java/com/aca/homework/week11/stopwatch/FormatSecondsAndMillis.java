package com.aca.homework.week11.stopwatch;

public class FormatSecondsAndMillis implements FormatTimeStrategy {

    @Override
    public String formatElapsedTime(long startMillis) {
        long elapsedTimeInMillis = System.currentTimeMillis() - startMillis;
        long seconds = elapsedTimeInMillis / 1000;
        long millis = elapsedTimeInMillis - seconds * 1000;
        String secondsString = seconds < 10 ? "0" + seconds : Long.toString(seconds);
        String millisString = millis < 10 ? "00" + millis : millis < 100 ? "0" + millis : Long.toString(millis);
        return secondsString + "." + millisString;
    }
}
