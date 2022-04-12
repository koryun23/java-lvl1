package com.aca.homework.week2.cars;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CarTest {
    public static void main(String[] args) {
        Car[] allCars = createCars("Porsche", 1980, 41);
        Car[] carsManufacturedAfter2010 = carsManufacturedAfter2010(allCars);
        printCars(carsManufacturedAfter2010);
    }
    public static Car createCar(String brand, int year){ // a method for creating a single car and returning it
        Car car = new Car();
        car.carBrand = brand;
        car.year = year;
        return car;
    }
    public static Car[] createCars(String brand, int year, int carCount){ // a method for creating multiple cars and returning them as an array
        Car[] cars = new Car[carCount];
        for(int i = 0; i < cars.length; i++){
            cars[i] = createCar(brand, i+year);
        }
        return cars;
    }
    public static Car[] carsManufacturedAfter2010(Car[] cars){ // a method for filtering the cars and returning the cars manufactured after 2010
        Car[] carsManufacturedAfter2010 = new Car[cars.length];
        int index = 0;
        for(Car car : cars){
            if (car.year >= 2010){
                carsManufacturedAfter2010[index] = car;
                index++;
            }
        }
        return Arrays.copyOfRange(carsManufacturedAfter2010, 0, index);
    }
    public static void printCars(Car[] cars){
        for(Car car : cars){
            System.out.println(car.carBrand + " " + car.year);
        }
    }
}
