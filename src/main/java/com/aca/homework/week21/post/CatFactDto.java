package com.aca.homework.week21.post;

import java.util.Objects;

public class CatFactDto {
    private String fact;
    private int length;

    public CatFactDto(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFactDto factDto = (CatFactDto) o;
        return length == factDto.length && Objects.equals(fact, factDto.fact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, length);
    }

    @Override
    public String toString() {
        return "FactDto{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
