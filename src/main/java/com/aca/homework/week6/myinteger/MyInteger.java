package com.aca.homework.week6.myinteger;

public class MyInteger {
    private static final MyInteger[] myIntegerObjects = new MyInteger[201];
    private final int value;

    private MyInteger(int value) {
        this.value = value;
    }

    public static MyInteger valueOf(int value) {
        if(valueIsOutOfRange(value)){
            return new MyInteger(value);
        }
        if (!myIntegerObjectExists(value)) {
            storeMyIntegerObject(value);
        }
        return myIntegerObjects[value + 100];
    }

    public static boolean valueIsOutOfRange(int value) {
        return value < -100 || value > 100;
    }

    public static boolean myIntegerObjectExists(int value) {
        return myIntegerObjects[value + 100] != null;
    }

    public static void storeMyIntegerObject(int value) {
        myIntegerObjects[value + 100] = new MyInteger(value);
    }

    public int getValue() {
        return value;
    }
}