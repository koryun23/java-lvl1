package com.aca.homework.week11.unique.cars;

import java.util.*;
import java.util.function.Supplier;

public class UniqueCars {

    private final Supplier<String> supplier;

    public UniqueCars(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    private static void printAllCars(Set<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static int numberOfUniqueCars(Set<Car> cars) {
        return cars.size();
    }

    private static boolean isEnd(String input) {
        return "finish".equals(input);
    }

    private static String getCarBrandName(String[] params) {
        return params[1];
    }

    private static String getCarModelName(String[] params) {
        return params[2];
    }

    private static boolean invalidInput(String[] params) {
        return params.length != 3;
    }

    public Set<Car> askAndCalculate() {
        Set<Car> cars = new TreeSet<>(new CarComparator());
        String input;
        while (true) {
            System.out.println("Please type your name, the brand, and model of your car(or type finish to terminate the program).");
            input = supplier.get();
            if (isEnd(input))
                break;
            String[] inputtedParameters = input.split(" ");
            if (invalidInput(inputtedParameters)) {
                throw new InvalidInputException(input);
            }

            cars.add(new Car(
                    getCarBrandName(inputtedParameters),
                    getCarModelName(inputtedParameters))
            );
        }
        return cars;
    }

    public void printAllData(Set<Car> cars) {
        System.out.println("Number of unique brand and models: " + numberOfUniqueCars(cars));
        printAllCars(cars);
    }

    private static class CarComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            int result = o1.getBrand().compareTo(o2.getBrand());
            if (result == 0) {
                return o1.getModel().compareTo(o2.getModel());
            }
            return result;
        }
    }

}
