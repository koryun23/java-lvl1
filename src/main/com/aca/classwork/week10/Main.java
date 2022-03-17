package com.aca.classwork.week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable sumRunnable = new SumRunnable(5, 6);
        Runnable mulRunnable = new MulRunnable(5, 6);
        Runnable subtractionRunnable = new SubtractionRunnable(5, 6);

        List<Runnable> list = new LinkedList<>();
        list.add(mulRunnable);
        list.add(subtractionRunnable);
        list.add(sumRunnable);

        mutate(list);
        runRunnable(list);
    }

    public static void mutate(List<Runnable> runnables) {
        runnables.remove(0);
        runnables = null;
    }
    public static void runRunnable(List<Runnable> runnables){
        for(Runnable runnable : runnables){
            runnable.run();
        }
    }
}
