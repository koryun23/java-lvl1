package com.aca.homework.week5.car;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        createMultipleCars(cars);
        printAll(cars);
    }
    public static void createMultipleCars(Car[] cars){
        for(int i = 0; i < cars.length; i++){
            Car car = createCar();
            if (car != null){
                cars[i] = car;
            }
        }
    }
    public static void printAll(Car[] cars){
        int carsCreated = 0;
        for (int i = 0; i < cars.length; i++){
            if(cars[i] != null) {
                System.out.format("%s) %s", ++carsCreated, cars[i].toString());
            }
        }
    }
    public static Car createCar(){
        String color = getColorInput();
        int weight = getWeightInput();
        int width = getWidthInput();
        String brand = getBrandInput();
        boolean carBrandValidated = validateCarName(brand);
        if(!carBrandValidated) return null;
        return new Car(color, weight, width, brand);
    }

    public static String getColorInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the color of the car: ");
        return scanner.nextLine();
    }
    public static int getWeightInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the weight of the car: ");
        return scanner.nextInt();
    }
    public static int getWidthInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width of the car: ");
        return scanner.nextInt();
    }
    public static String getBrandInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the brand of the car(all lowercase): ");
        return scanner.nextLine();
    }
    public static boolean validateCarName(String brand){
        return "bmw".equals(brand) || "hyundai".equals(brand);
    }
}
