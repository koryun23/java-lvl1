package com.aca.homework.week21.post.dto;

import java.util.Objects;

public class CatFactDto {
    private String fact;
    private int length;

    public CatFactDto(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public CatFactDto() {
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
        CatFactDto that = (CatFactDto) o;
        return length == that.length && Objects.equals(fact, that.fact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, length);
    }

    @Override
    public String toString() {
        return "CatFactDto{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
