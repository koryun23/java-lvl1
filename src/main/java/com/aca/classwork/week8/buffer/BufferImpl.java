package com.aca.classwork.week8.buffer;

public class BufferImpl<T> implements Buffer<T> {

    private T o;

    @Override
    public void put(T o) {
        this.o = o;
    }

    @Override
    public T get() {
        return this.o;
    }

    public static void main(String[] args) {
        Buffer<Integer> integerBuffer = new Buffer<>() {
            @Override
            public void put(Integer o) {

            }

            @Override
            public Integer get() {
                return null;
            }
        };

        integerBuffer.put(45);
        Integer integer = integerBuffer.get();

    }
}
