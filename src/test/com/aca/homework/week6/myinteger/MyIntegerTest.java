package com.aca.homework.week6.myinteger;

class MyIntegerTest {
    public static void main(String[] args) {
        System.out.println(MyInteger.valueOf(10).getValue());
        System.out.println(MyInteger.valueOf(10).getValue());
        System.out.println(MyInteger.valueOf(100).getValue());
        System.out.println(MyInteger.valueOf(-100).getValue());
        System.out.println(MyInteger.valueOf(101).getValue()); // won't be cached
    }
}