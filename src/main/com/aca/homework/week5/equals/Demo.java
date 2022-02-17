package com.aca.homework.week5.equals;

public class Demo {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Mark", "Yorgantz");
        Owner owner2 = new Owner("Mark", "tavares");

        Motorcycle moto1 = new Motorcycle(owner1, MotorcycleType.YAMAHA);
        Motorcycle moto2 = new Motorcycle(owner2, MotorcycleType.YAMAHA);

        System.out.println(moto1.equals(moto2));

    }
}
