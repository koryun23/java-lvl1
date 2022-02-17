package com.aca.classwork.week6.buffer;

public class ArrayBuffer implements Buffer {
    private final String[] value = new String[1];

    @Override
    public void put(String value) {
        System.out.println("ArrayBuffer put");
        this.value[0] = value;
    }

    @Override
    public String get() {
        System.out.println("ArrayBuffer get");
        return value[0];
    }

}
