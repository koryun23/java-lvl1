package com.aca.homework.week9.donate;

public class SmartWatch extends DonatableProduct implements Donatable {
    public SmartWatch(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Smart watch with price $" + getPrice();
    }
}
