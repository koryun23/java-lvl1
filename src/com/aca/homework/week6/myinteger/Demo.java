package com.aca.homework.week6.myinteger;

public class Demo {
    public static void main(String[] args) {
        MyInteger myInteger = MyInteger.valueOf(50);
        MyInteger myInteger2 = MyInteger.valueOf(100);
        MyInteger myInteger3 = MyInteger.valueOf(-100);
        MyInteger myInteger4 = MyInteger.valueOf(50);
        MyInteger myInteger5 = MyInteger.valueOf(0);

        // MyInteger myInteger4 = MyInteger.createNewInteger(101); throws IllegalArgumentException
        // MyInteger myInteger5 = MyInteger.createNewInteger(-101); throws IllegalArgumentException

        System.out.println(myInteger.getValue());
        System.out.println(myInteger2.getValue());
        System.out.println(myInteger3.getValue());
        System.out.println(myInteger4.getValue());
        System.out.println(myInteger5.getValue());

    }
}
