package com.aca.homework.week11.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StopWatchTest {
    @Test
    public void testSleep() {
        long startMillis = System.currentTimeMillis();
        StopWatch.sleep(10);
        Assertions.assertTrue(System.currentTimeMillis() - startMillis >= 10);
    }
}