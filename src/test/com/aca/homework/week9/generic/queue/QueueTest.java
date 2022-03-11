package com.aca.homework.week9.generic.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class QueueTest {
    private Queue<String> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Queue<>();
    }

    @Test
    public void testWhenProduceIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                testSubject.produce(null);
            }
        });
    }

    @Test
    public void testConsumeWhenContains1Item() {
        testSubject.produce("test");
        Assertions.assertEquals(testSubject.consume(), "test");
    }

    @Test
    public void testConsumeWhenQueueIsEmpty() {
        Assertions.assertThrows(QueueEmptyException.class, new Executable() {
            @Override
            public void execute() {
                testSubject.consume();
            }
        });
    }

    @Test
    public void testConsume2TimesWhenQueueContians2Items() {
        testSubject.produce("test1");
        testSubject.produce("test2");
        Assertions.assertEquals("test1", testSubject.consume());
        Assertions.assertEquals("test2", testSubject.consume());
        Assertions.assertEquals(0, testSubject.size());
    }

    @Test
    public void testConsume2TimesWhenQueueContains3Items() {
        testSubject.produce("test1");
        testSubject.produce("test2");
        testSubject.produce("test3");
        Assertions.assertEquals("test1", testSubject.consume());
        Assertions.assertEquals("test2", testSubject.consume());
        Assertions.assertEquals(1, testSubject.size());
    }
}