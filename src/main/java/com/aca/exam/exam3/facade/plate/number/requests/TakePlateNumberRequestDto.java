package com.aca.exam.exam3.facade.plate.number.requests;

import java.util.Objects;

public class TakePlateNumberRequestDto {

    private final String passport;
    private final String plateNumber;

    public TakePlateNumberRequestDto(String passport, String plateNumber) {
        this.passport = passport;
        this.plateNumber = plateNumber;
    }

    public String getPassport() {
        return passport;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakePlateNumberRequestDto that = (TakePlateNumberRequestDto) o;
        return Objects.equals(passport, that.passport) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, plateNumber);
    }

    @Override
    public String toString() {
        return "TakePlateNumberRequestDto{" +
                "passport='" + passport + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
