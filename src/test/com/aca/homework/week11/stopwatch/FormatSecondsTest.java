package com.aca.homework.week11.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatSecondsTest {
    private FormatTimeStrategy testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new FormatSeconds();
    }

    @Test
    public void testWaitSecondsAndMillisElapsedTimeWhenIs0() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis());
        System.out.println(elapsedTime);
        Assertions.assertEquals("00", elapsedTime);
    }

    @Test
    public void testWaitSecondsAndMillisElapsedTimeWhenIsGT0() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis() - 5);
        System.out.println(elapsedTime);
        Assertions.assertEquals("00", elapsedTime);
    }

    @Test
    public void testWaitSecondsAndMillisElapsedTimeWhenisGT1Second() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis() - 1001);
        System.out.println(elapsedTime);
        Assertions.assertEquals("01", elapsedTime);
    }
}