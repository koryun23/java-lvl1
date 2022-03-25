package com.aca.homework.week11.stopwatch;

public interface WaitingStrategy {
    void print(long startMillis);

    String getElapsedTime(long startMillis);
}
