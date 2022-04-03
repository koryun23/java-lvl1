package com.aca.homework.week13.race.condition.list;

public class SafeList<E> implements List<E> {

    private int size = 0;
    private final Object[] arr = new Object[10_000];

    @Override
    public synchronized void add(E item) {
        arr[size++] = item;
    }

    @Override
    public synchronized int size() {
        return size;
    }
}
