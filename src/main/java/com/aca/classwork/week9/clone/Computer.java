package com.aca.classwork.week9.clone;

public class Computer implements ConstructorCloneable<Computer>{
    private String brand;

    public Computer(String brand){
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString(){
        return "Computer " + brand;
    }

    @Override
    public Computer doClone(){
        return new Computer(this.brand);
    }
}
