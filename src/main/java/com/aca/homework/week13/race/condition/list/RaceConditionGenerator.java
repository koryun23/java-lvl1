package com.aca.homework.week13.race.condition.list;

import java.util.Scanner;
import java.util.function.Supplier;

public class RaceConditionGenerator {

    Supplier<Boolean> listTypeSupplier;

    public RaceConditionGenerator(Supplier<Boolean> listTypeSupplier) {
        this.listTypeSupplier = listTypeSupplier;
    }
    public int start() {
        List<Integer> list = new ListFactory(listTypeSupplier).getList();
        Thread[] threads = createThreads(0, list);
        startThreads(threads);
        joinThreads(threads);

        return list.size();
    }

    public Thread[] createThreads(Integer number, List<Integer> list) {
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(new NumberAdderRunnable(number, list));
        }
        return threads;
    }

    public void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void joinThreads(Thread[] threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
