package com.aca.homework.week14.shared.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SharedListMainTest {

    private SharedListMain testSubject;

    @BeforeEach
    public void init() {
        testSubject = new SharedListMain();
    }

    @Test
    public void testStart() {
        Assertions.assertEquals(1000, testSubject.start());
    }
}