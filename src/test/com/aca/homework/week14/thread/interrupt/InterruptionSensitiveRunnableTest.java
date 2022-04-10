package com.aca.homework.week14.thread.interrupt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class InterruptionSensitiveRunnableTest {

    @Test
    public void testImmediateInterrupt() {
        List<String> sharedList = new LinkedList<>();
        Thread thread = new Thread(new InterruptionSensitiveRunnable(sharedList));
        thread.start();
        thread.interrupt();

        Assertions.assertEquals(0, sharedList.size());
    }

    @Test
    public void testInterruptIn1Sec() {
        List<String> sharedList = new LinkedList<>();
        Thread thread = new Thread(new InterruptionSensitiveRunnable(sharedList));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        Assertions.assertEquals(0, sharedList.size());
    }

    @Test
    public void testInterruptIn3Sec() {
        List<String> sharedList = new LinkedList<>();
        Thread thread = new Thread(new InterruptionSensitiveRunnable(sharedList));
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        Assertions.assertEquals(1, sharedList.size());
    }

    @Test
    public void testInterruptIn5Sec() {
        List<String> sharedList = new LinkedList<>();
        Thread thread = new Thread(new InterruptionSensitiveRunnable(sharedList));
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        Assertions.assertEquals(2, sharedList.size());
    }
}