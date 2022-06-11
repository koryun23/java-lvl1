package com.aca.exam.exam3.facade.plate.number.requests;

import java.util.Objects;

public class CreatePlateNumberRequestDto {

    private final String plateNumber;
    private final String passport;

    public CreatePlateNumberRequestDto(String plateNumber, String passport) {
        this.plateNumber = plateNumber;
        this.passport = passport;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePlateNumberRequestDto that = (CreatePlateNumberRequestDto) o;
        return Objects.equals(plateNumber, that.plateNumber) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, passport);
    }

    @Override
    public String toString() {
        return "CreatePlateNumberRequestDto{" +
                "plateNumber='" + plateNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
