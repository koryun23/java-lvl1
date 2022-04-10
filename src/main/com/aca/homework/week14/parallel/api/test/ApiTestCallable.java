package com.aca.homework.week14.parallel.api.test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiTestCallable implements Callable<Test> {

    private static final AtomicInteger number = new AtomicInteger(0);
    private static final Random generator = new Random();

    @Override
    public Test call() throws Exception {
        Thread.sleep(2000);
        synchronized (number) {
            return new Test(generator.nextInt(100) > 50 ? TestResult.PASS : TestResult.FAIL,
                    "test" + number,
                    "test description " + number.incrementAndGet());
        }
    }
}
