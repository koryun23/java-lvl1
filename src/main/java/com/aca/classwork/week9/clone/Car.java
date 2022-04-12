package com.aca.classwork.week9.clone;

public class Car implements ConstructorCloneable<Car>{
    private int age;

    public Car(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Car doClone() {
        return new Car(this.age); // bad idea to clone objects using constructors
    }

    @Override
    public String toString() {
        return "Car " + age;
    }
}
