package com.aca.classwork.week5.developer;

public class Printers {
    public static void main(String[] args) {
        int i = 456;
        print(456);
        Integer i1 = 456;
    }
    public static void printAll(Object[] objects){
        for(Object obj : objects){
            System.out.println(obj.toString());
        }
    }
    public static void print(Object obj){
        System.out.println("----" + obj.toString());
    }
}
