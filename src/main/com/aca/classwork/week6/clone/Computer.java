package com.aca.classwork.week6.clone;

public class Computer implements Cloneable{

    private Brand type;

    public Computer(Brand type) {
        this.type = type;
    }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        return (Computer) super.clone();
    }
}
