package com.aca.homework.week13.race.condition.list;

public class UnsafeList<E> implements List<E> {

    private int size = 0;
    private final Object[] arr = new Object[10_000];

    @Override
    public void add(E item) {
        arr[size++] = item;
    }

    @Override
    public int size() {
        return size;
    }
}
