package com.aca.homework.week8.car.repository;

public class Car {
    private final String vin;
    private int year;
    private int ownersCount;

    public Car(String vin, int year, int ownersCount) {
        this.vin = vin;
        setYear(year);
        setOwnersCount(ownersCount);
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 0)
            throw new IllegalArgumentException("Year must be positive");
        this.year = year;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public void setOwnersCount(int ownersCount) {
        if(ownersCount < 1)
            throw new IllegalArgumentException("Owner's count must be >= 1");
        this.ownersCount = ownersCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Car) {
            Car other = (Car) obj;
            return other.vin.equals(this.vin) && other.year == this.year && other.ownersCount == this.ownersCount;
        }
        return false;
    }
}
