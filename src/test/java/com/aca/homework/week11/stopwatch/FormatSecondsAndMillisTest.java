package com.aca.homework.week11.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatSecondsAndMillisTest {
    private FormatTimeStrategy testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new FormatSecondsAndMillis();
    }

    @Test
    public void testFormatSecondsAndMillisElapsedTimeWhenIs0() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis());
        System.out.println(elapsedTime);
        Assertions.assertEquals(6, elapsedTime.length());
        Assertions.assertEquals("00", elapsedTime.substring(0, 2));
    }

    @Test
    public void testFormatSecondsAndMillisElapsedTimeWhenIsGT0() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis() - 5);
        System.out.println(elapsedTime);
        Assertions.assertEquals(6, elapsedTime.length());
        Assertions.assertEquals("00", elapsedTime.substring(0, 2));
    }

    @Test
    public void testWaitSecondsAndMillisElapsedTimeWhenisGT1Second() {
        String elapsedTime = testSubject.formatElapsedTime(System.currentTimeMillis() - 1001);
        System.out.println(elapsedTime);
        Assertions.assertEquals(6, elapsedTime.length());
        Assertions.assertEquals("01", elapsedTime.substring(0, 2));
    }
}