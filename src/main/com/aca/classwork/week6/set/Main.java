package com.aca.classwork.week6.set;

public class Main {
    public static void main(String[] args) {
        Set set = new ArraySet();
        set.add(new User("F", "L"));
        set.add(new User("F", "L"));
        set.add(new User("F", "L"));
        set.add(new User("F", "L"));
        set.add(new User("F", "L"));
        System.out.println(set.size());
    }
}
