package com.aca.homework.week11.runnable.printer;

import java.util.*;

public class SortedPrinterRunnableTest {
    public static void main(String[] args) {
        Set<SortedNumberPrinterRunnable> runnables = createRunnables();
        runAll(new ArrayList<>(runnables));
    }

    public static Set<SortedNumberPrinterRunnable> createRunnables() {
        Set<SortedNumberPrinterRunnable> runnables = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(SortedNumberPrinterRunnable o1, SortedNumberPrinterRunnable o2) {
                return Integer.compare(o1.getWaitingTime(), o2.getWaitingTime());
            }
        });
        for (int i = 1; i <= 100; i++) {
            runnables.add(new SortedNumberPrinterRunnable(i));
        }
        return runnables;
    }

    public static void runAll(List<Runnable> list) {
        for (Runnable runnable : list) {
            runnable.run();
        }
    }
}
