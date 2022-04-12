package com.aca.classwork.week8.scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class IntScannerTest {
    private IntScanner testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new IntScanner(new IntSupplierForTest());
    }

    @Test
    public void testGet5SizedArray(){
        int[] sizedArray = testSubject.get5SizedArray();

        Assertions.assertEquals(9, sizedArray[0]);
        Assertions.assertEquals(10, sizedArray[1]);
        Assertions.assertEquals(4, sizedArray[2]);
        Assertions.assertEquals(5, sizedArray[3]);
        Assertions.assertEquals(6, sizedArray[4]);
    }
}