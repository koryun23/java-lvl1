package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberAdderRunnableTest {
    private NumberAdderRunnable testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new NumberAdderRunnable(-10, new SafeList<>());
    }

    @Test
    public void testAdd() {
        testSubject.run();
        Assertions.assertEquals(1, testSubject.getList().size());
    }
}