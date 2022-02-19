package com.aca.homework.week6.list;

public class Demo {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        for(int i = 0; i < 73; i++){
            arrayList.add(String.format("text %d", i));
            System.out.println(arrayList.get(i));
        }
        arrayList.add(null);
        arrayList.add(null);
        System.out.println(arrayList.get(74)); // prints null
        //System.out.println(arrayList.get(75)); throws RuntimeException
    }
}
