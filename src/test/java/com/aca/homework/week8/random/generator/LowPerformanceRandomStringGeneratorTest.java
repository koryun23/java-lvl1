package com.aca.homework.week8.random.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowPerformanceRandomStringGeneratorTest {
    private LowPerformanceRandomStringGenerator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new LowPerformanceRandomStringGenerator();
    }

    @Test
    public void testWrongNumber() {
        Result result = testSubject.randomString(4);
        assertEquals("error", result.getText());
        assertEquals(0, result.getDuration());
    }

    @Test
    public void test30000() {
        Result result = testSubject.randomString(30000);
        assertTrue(result.getDuration() > 0);
        assertEquals(30000, result.getText().length());
    }
}