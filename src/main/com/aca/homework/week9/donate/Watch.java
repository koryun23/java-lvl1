package com.aca.homework.week9.donate;

public class Watch extends DonatableProduct implements Donatable {
    public Watch(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Watch with price $" + getPrice();
    }
}
