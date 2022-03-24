package com.aca.homework.week11.runnable.printer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Set<Runnable> runnables = createRunnables();
        runAll(sortedCopyOf(runnables));
    }
    public static Set<Runnable> createRunnables(){
        Set<Runnable> runnables = new HashSet<>();
        for(int i = 1; i <= 100; i++) {
            runnables.add(new SortedNumberPrinterRunnable(i));
        }
        return runnables;
    }

    public static void runAll(List<Runnable> list){
        for(Runnable runnable : list) {
            runnable.run();
        }
    }
    private static List<Runnable> sortedCopyOf(Set<Runnable> set) {
        List<Runnable> runnableList = getListFromSet(set);
        runnableList.sort(new Comparator<Runnable>() {
            @Override
            public int compare(Runnable o1, Runnable o2) {
                return ((SortedNumberPrinterRunnable) o1).getWaitingTime() - ((SortedNumberPrinterRunnable) o2).getWaitingTime();
            }
        });
        return runnableList;
    }

    private static List<Runnable> getListFromSet(Set<Runnable> set) {
        List<Runnable> runnableList = new LinkedList<>();
        for(Runnable runnable : set) {
            runnableList.add(runnable);
        }
        return runnableList;
    }
}
