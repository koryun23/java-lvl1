package com.aca.homework.week6.myinteger;

public class MyInteger {
    private static final MyInteger[] myIntegerObjects = new MyInteger[201];
    private final int value;

    private MyInteger(int value) {
        this.value = value;
    }

    public static MyInteger valueOf(int value) {
        checkNumberRange(value);
        if (!myIntegerObjectExists(value)) {
            cacheMyIntegerObject(value);
        }
        return myIntegerObjects[value + 100];
    }

    public static void checkNumberRange(int value) {
        if (value < -100 || value > 100) {
            throw new IllegalArgumentException("The inputted number must be >= -100 and <= 100");
        }
    }

    public static boolean myIntegerObjectExists(int value) {
        return myIntegerObjects[value + 100] != null;
    }

    public static void cacheMyIntegerObject(int value) {
        myIntegerObjects[value + 100] = new MyInteger(value);

    }

    public int getValue() {
        return value;
    }
}
