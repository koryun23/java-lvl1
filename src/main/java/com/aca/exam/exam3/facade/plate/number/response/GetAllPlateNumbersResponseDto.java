package com.aca.exam.exam3.facade.plate.number.response;

import com.aca.exam.exam3.entity.UserPlateNumber;

import java.util.List;
import java.util.Objects;

public class GetAllPlateNumbersResponseDto {

    private final List<UserPlateNumber> userPlateNumberList;
    private final String passport;

    public GetAllPlateNumbersResponseDto(List<UserPlateNumber> userPlateNumberList, String passport) {
        this.userPlateNumberList = userPlateNumberList;
        this.passport = passport;
    }

    public List<UserPlateNumber> getUserPlateNumberList() {
        return userPlateNumberList;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAllPlateNumbersResponseDto that = (GetAllPlateNumbersResponseDto) o;
        return Objects.equals(userPlateNumberList, that.userPlateNumberList) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userPlateNumberList, passport);
    }

    @Override
    public String toString() {
        return "GetAllPlateNumbersResponseDto{" +
                "userPlateNumberList=" + userPlateNumberList +
                ", passport='" + passport + '\'' +
                '}';
    }
}
