package com.aca.homework.week9.donate;

public class SmartWatch implements Donatable {
    private final double price;

    public SmartWatch(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 5 / 100;
    }

    @Override
    public String toString() {
        return "Smart watch with price $" + price;
    }
}
