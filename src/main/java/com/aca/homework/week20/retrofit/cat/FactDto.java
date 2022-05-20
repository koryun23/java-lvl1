package com.aca.homework.week20.retrofit.cat;

import java.util.Objects;

public class FactDto {

    private String fact;
    private Integer length;

    public FactDto() {
    }

    public FactDto(String fact, Integer length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactDto factDto = (FactDto) o;
        return Objects.equals(fact, factDto.fact) && Objects.equals(length, factDto.length);
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
