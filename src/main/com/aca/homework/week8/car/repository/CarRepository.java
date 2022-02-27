package com.aca.homework.week8.car.repository;

public class CarRepository {
    private Car[] cars = new Car[1000];
    private int numberOfCars = 0;

    public Car save(Car car){
        if(findByVin(car.getVin()) != null){
            return null;
        }
        cars[numberOfCars++] = car;
        return car;
    }

    public Car findByVin(String vin){
        for(Car car : cars){
            if (car != null && car.getVin().equals(vin)){
                return car;
            }
        }
        return null;
    }

    public int getTotalCount(){
        return numberOfCars;
    }
}
