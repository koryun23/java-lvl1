package com.aca.classwork.week7.clone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal tiger = new Animal(AnimalType.PREDATOR, "TIGER");
        System.out.println(tiger.clone().getClass());
    }
}
