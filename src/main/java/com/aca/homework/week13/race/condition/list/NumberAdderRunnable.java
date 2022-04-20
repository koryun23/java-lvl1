package com.aca.homework.week13.race.condition.list;

public class NumberAdderRunnable implements Runnable {

    private final Integer number;
    private final List<Integer> list;

    public NumberAdderRunnable(Integer number, List<Integer> list) {
        this.number = number;
        this.list = list;
    }

    @Override
    public void run() {
        list.add(number);
    }

    public Integer getNumber() {
        return number;
    }

    public List<Integer> getList() {
        return list;
    }
}