package com.aca.homework.week11.unique.cars;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        UniqueCars uniqueCars = new UniqueCars(new Supplier<String>() {
            @Override
            public String get() {
                return new Scanner(System.in).nextLine();
            }
        });

        Set<Car> cars = uniqueCars.askAndCalculate();
        uniqueCars.printAllData(cars);
    }
}
