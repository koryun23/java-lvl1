package com.aca.classwork.week6.buffer;

public class MyBuffer implements Buffer {
    private String value;

    @Override
    public void put(String value) {
        System.out.println("String buffer put");
        this.value = value;
    }

    @Override
    public String get() {
        System.out.println("String buffer get");
        return value;
    }


}

