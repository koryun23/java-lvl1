package com.aca.exam.exam3.service.core;

import com.aca.exam.exam3.entity.User;

import java.util.Objects;

public class UserPlateNumberUpdateParams {

    private final Long id;
    private final String plateNumber;
    private final String passport;

    public UserPlateNumberUpdateParams(Long id, String plateNumber, String passport) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    public String getPassport() {
        return passport;
    }

    public String getPlateNubmer() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlateNumberUpdateParams that = (UserPlateNumberUpdateParams) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNumber, that.plateNumber) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber, passport);
    }

    @Override
    public String toString() {
        return "UserPlateNumberUpdateParams{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
