package com.aca.homework.week11.runnable.printer;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Runnable> createRunnables() {
        List<Runnable> runnableList = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            runnableList.add(new NumberPrinterRunnable(i));
        }
        return runnableList;
    }

    public static void runAll(List<Runnable> runnableList) {
        for (Runnable runnable : runnableList) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        List<Runnable> runnables = createRunnables();
        runAll(runnables);
    }
}