package com.aca.classwork.week7.string.performance;

public interface StringMaker {
    StringMakerResult make(int start, int end);
    static StringMaker ofBad(){
        return new StringMakerImpl();
    }

    static StringMaker ofGood(){
        return new GoodStringMaker();
    }
}
