package com.aca.homework.week6.list;

public class Demo {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        for(int i = 0; i < 73; i++){
            arrayList.add(String.format("text %d", i));
            System.out.println(arrayList.get(i));
        }
        // System.out.println(arrayList.get(73)); throws RuntimeException
    }
}
