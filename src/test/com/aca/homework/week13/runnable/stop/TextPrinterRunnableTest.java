package com.aca.homework.week13.runnable.stop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextPrinterRunnableTest {

    private TextPrinterRunnable testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new TextPrinterRunnable(s -> System.out.println(s), "Hello World");
    }

    @Test
    public void testRun() {
        Assertions.assertEquals("Hello World", testSubject.getPrintedText());
    }
}