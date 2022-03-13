package com.aca.homework.week9.donate;

public class Smartphone extends DonatableProduct implements Donatable {
    public Smartphone(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Smartphone with price $" + getPrice();
    }
}
