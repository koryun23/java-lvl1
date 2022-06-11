package com.aca.exam.exam3.facade.plate.number.requests;

import java.util.Objects;

public class GetAllPlateNumbersRequestDto {

    private final String passport;

    public GetAllPlateNumbersRequestDto(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAllPlateNumbersRequestDto that = (GetAllPlateNumbersRequestDto) o;
        return Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "GetAllPlateNumbersRequestDto{" +
                "passport='" + passport + '\'' +
                '}';
    }
}
