package com.aca.classwork.week7.clone;

public class Animal implements Cloneable{
    private AnimalType type;
    private String name;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    protected Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }
}
