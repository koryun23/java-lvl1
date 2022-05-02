package com.aca.exam.exam3.facade.plate.number.response;

import java.util.Objects;

public class CreatePlateNumberResponseDto {

    private final String plateNumber;
    private final String passport;

    public CreatePlateNumberResponseDto(String plateNumber, String passport) {
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
        CreatePlateNumberResponseDto that = (CreatePlateNumberResponseDto) o;
        return Objects.equals(plateNumber, that.plateNumber) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, passport);
    }

    @Override
    public String toString() {
        return "CreatePlateNumberResponseDto{" +
                "plateNumber='" + plateNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
