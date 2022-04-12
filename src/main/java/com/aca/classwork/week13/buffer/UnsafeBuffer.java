package com.aca.classwork.week13.buffer;

public class UnsafeBuffer<T> implements Buffer<T> {

    private T value;

    @Override
    public T get() throws InterruptedException {
        if (value == null) {
            throw new IllegalStateException();
        }
        T valueToReturn = value;
        value = null;
        return valueToReturn;
    }

    @Override
    public void put(final T t) throws InterruptedException {
        if (value != null) {
            throw new IllegalStateException();
        }
        this.value = t;
    }
}