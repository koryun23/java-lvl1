package com.aca.homework.week9.donate;

public class Smartphone implements Donatable {
    private final double price;

    public Smartphone(double price) {
        this.price = price;
    }

    public double donationAmount() {
        return price * 5 / 100;
    }

    @Override
    public String toString() {
        return "Smartphone with price $" + price;
    }
}
