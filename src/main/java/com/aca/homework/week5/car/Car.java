package com.aca.homework.week5.car;

public class Car {
    private String color;
    private int weight;
    private int width;
    private String brand;

    public Car(String color, int weight, int width, String brand){
        this.color = color;
        this.weight = weight;
        this.width = width;
        this.brand = brand;
    }

    public String getColor(){
        return color;
    }

    public int getWeight(){
        return weight;
    }

    public int getWidth(){
        return width;
    }

    public String getBrand(){
        return brand;
    }

    @Override
    public String toString(){
        return String.format("%s: %s, %s: %s, %s: %s, %s: %s\n",
                    "brand", this.brand,
                    "color", this.color,
                    "width", this.width,
                    "weight", this.weight
                );
    }

}
