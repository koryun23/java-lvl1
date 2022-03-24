package com.aca.homework.week11.unique.cars;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private final String brand;
    private final String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }


    @Override
    public int compareTo(Car o) {
        int result = this.brand.compareTo(o.getBrand());
        if(result == 0){
            return this.model.compareTo(o.getModel());
        }
        return result;
    }
}
