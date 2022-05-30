package com.aca.homework.week14.parallel.api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
    private Main testSubject;

    @BeforeEach
    public void init() {
        testSubject = new Main();
    }

    @Test
    public void testMapSize() {
        Assertions.assertEquals(5000, testSubject.start().size());
    }
}