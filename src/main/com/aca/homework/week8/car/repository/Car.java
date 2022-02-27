package com.aca.homework.week8.car.repository;

public class Car {
    private String vin;
    private int year;
    private int ownersCount;

    public Car(String vin, int year, int ownersCount) {
        this.vin = vin;
        this.year = year;
        this.ownersCount = ownersCount;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof Car){
            Car other = (Car) obj;
            return other.vin.equals(this.vin) && other.year == this.year && other.ownersCount == this.ownersCount;
        }
        return false;
    }
}
