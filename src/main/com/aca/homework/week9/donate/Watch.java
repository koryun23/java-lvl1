package com.aca.homework.week9.donate;

public class Watch implements Donatable {
    public double price;

    public Watch(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 5 / 100;
    }

    @Override
    public String toString() {
        return "Watch with price $" + price;
    }
}
