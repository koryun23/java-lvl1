package com.aca.exam.exam3.facade.user.requests;

import java.util.Objects;

public class GetUserByPassportIdRequestDto {
    private final String passport;

    public GetUserByPassportIdRequestDto(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserByPassportIdRequestDto that = (GetUserByPassportIdRequestDto) o;
        return Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "GetUserByPassportIdRequestDto{" +
                "passport='" + passport + '\'' +
                '}';
    }
}
