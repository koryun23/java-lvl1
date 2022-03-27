package com.aca.additional.deitel.ch26.sec05;

public interface Buffer {

    void set(int value) throws InterruptedException;

    int get() throws InterruptedException;
}
