package com.aca.homework.week9.donate;

public class DonatableProduct implements Donatable{
    private double price;

    public DonatableProduct(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public double donationAmount(){
        return price * 5 / 100;
    }


}
