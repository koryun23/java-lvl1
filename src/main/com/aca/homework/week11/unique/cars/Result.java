package com.aca.homework.week11.unique.cars;

import java.util.Set;

public class Result {

    private final Set<Car> uniqueCars;

    public Result(Set<Car> cars) {
        uniqueCars = cars;
    }

    public int numberOfUniqueCars() {
        return uniqueCars.size();
    }

    public String allCarsToString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : uniqueCars) {
            sb.append(car);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printAllData() {
        System.out.println("Number of unique brand and models: " + numberOfUniqueCars() + "\n" + allCarsToString());
    }
}
