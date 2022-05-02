package com.aca.exam.exam3.service.core.plate.number;

import org.springframework.util.Assert;

import java.util.Objects;

public class UserPlateNumberCreationParams {
    private final String plateNumber;
    private final String passport;

    public UserPlateNumberCreationParams(String plateNumber, String passport) {
        Assert.notNull(plateNumber, "plate number should not be null");
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
        UserPlateNumberCreationParams that = (UserPlateNumberCreationParams) o;
        return Objects.equals(plateNumber, that.plateNumber) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, passport);
    }

    @Override
    public String toString() {
        return "UserPlateNumberCreationParams{" +
                "plateNumber='" + plateNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
