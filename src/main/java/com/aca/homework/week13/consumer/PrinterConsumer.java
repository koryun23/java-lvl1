package com.aca.homework.week13.consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PrinterConsumer implements Consumer<String> {

    private int timesAccessed = 0;
    private final List<String> argumentsTaken;

    public PrinterConsumer() {
        argumentsTaken = new LinkedList<>();
    }

    @Override
    public void accept(String s) {
        System.out.println(s);
        timesAccessed++;
        argumentsTaken.add(s);
    }

    public int getTimesAccessed() {
        return timesAccessed;
    }

    public List<String> getArgumentsTaken() {
        return argumentsTaken;
    }
}
