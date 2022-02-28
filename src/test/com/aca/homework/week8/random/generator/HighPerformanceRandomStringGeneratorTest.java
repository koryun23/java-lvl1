package com.aca.homework.week8.random.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighPerformanceRandomStringGeneratorTest {
    private HighPerformanceRandomStringGenerator testSubject;
    @BeforeEach
    public void setUp(){
        testSubject = new HighPerformanceRandomStringGenerator();
    }

    @Test
    public void testWrongNumber(){
        Result result = testSubject.randomString(4);
        boolean containsErrorString = "error".equals(result.getText());
        boolean durationIs0 = result.getDuration() == 0;
        assertTrue(containsErrorString && durationIs0);
    }

    @Test
    public void test30000(){
        Result result = testSubject.randomString(30000);
        boolean durationGT0 = result.getDuration() > 0;
        boolean textLengthEq30000 = result.getText().length() == 30000;
        assertTrue(durationGT0 && textLengthEq30000);
    }
}