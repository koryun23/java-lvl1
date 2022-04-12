package com.aca.homework.week8.random.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class HighPerformanceRandomStringGeneratorTest {
    private HighPerformanceRandomStringGenerator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HighPerformanceRandomStringGenerator();
    }

    @Test
    public void testWrongNumber() {
        Result result = testSubject.randomString(4);
        System.out.println(result.getDuration());
        assertEquals(0, result.getDuration());
        assertEquals("error", result.getText());
    }

    @Test
    public void test30000() {
        Result result = testSubject.randomString(30000);
        assertTrue(result.getDuration() > 0);
        assertEquals(30000, result.getText().length());
        System.out.println(result.getDuration());
    }
}