package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnsafeListTest {
    private UnsafeList<Integer> testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new UnsafeList<>();
    }

    @Test
    public void testSizeWhenEmpty(){
        Assertions.assertEquals(0, testSubject.size());
    }

    @Test
    public void testAddAndSize(){
        testSubject.add(1);
        testSubject.add(2);
        Assertions.assertEquals(2, testSubject.size());
    }
}