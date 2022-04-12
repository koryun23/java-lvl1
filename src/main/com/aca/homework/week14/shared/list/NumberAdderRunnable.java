package com.aca.homework.week14.shared.list;

import java.util.List;

public class NumberAdderRunnable implements Runnable {

    private final int number;
    private final List<Integer> list;

    public NumberAdderRunnable(int number, List<Integer> list) {
        this.number = number;
        this.list = list;
    }

    @Override
    public void run() {
        list.add(number);
    }
}
