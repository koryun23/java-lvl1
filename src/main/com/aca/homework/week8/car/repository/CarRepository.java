package com.aca.homework.week8.car.repository;

public class CarRepository {
    private final Car[] cars = new Car[1000];
    private int numberOfCars = 0;

    public Car save(Car car) {
        Car carToUpdate = findByVin(car.getVin());
        if (carToUpdate == null) {
            cars[numberOfCars++] = car;
            return car;
        }
        update(carToUpdate, car.getOwnersCount(), car.getYear());
        cars[numberOfCars] = car;
        return car;
    }

    public void update(Car carToUpdate, int newOwnersCount, int newYear) {
        carToUpdate.setOwnersCount(newOwnersCount);
        carToUpdate.setYear(newYear);
    }

    public Car findByVin(String vin) {
        for (Car car : cars) {
            if (car != null && car.getVin().equals(vin)) {
                return car;
            }
        }
        return null;
    }

    public int getTotalCount() {
        return numberOfCars;
    }
}
