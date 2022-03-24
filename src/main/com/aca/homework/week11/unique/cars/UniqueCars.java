package com.aca.homework.week11.unique.cars;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;

public class UniqueCars {

    private final Supplier<String> supplier;

    public UniqueCars(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public Set<Car> askAndCalculate() {
        Set<Car> cars = new HashSet<>();
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

    public void printResult(Set<Car> cars) {
        new Result(cars).printAllData();
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

}
