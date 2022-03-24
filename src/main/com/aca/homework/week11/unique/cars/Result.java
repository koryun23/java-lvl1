package com.aca.homework.week11.unique.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Result {

    private final List<Car> uniqueCars;

    public Result(Set<Car> cars) {
        uniqueCars = sortedCopyOf(cars);
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

    private List<Car> sortedCopyOf(Set<Car> cars) {
        List<Car> listOfCars = new ArrayList<>();
        for(Car car : cars) {
            listOfCars.add(car);
        }
        Collections.sort(listOfCars);
        return listOfCars;
    }
}
