package com.aca.homework.week11.stopwatch;

public interface ElapsedTimeStrategy {
    void print(long startMillis);

    String getElapsedTime(long startMillis);
}
