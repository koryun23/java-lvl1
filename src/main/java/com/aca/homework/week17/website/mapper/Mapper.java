package com.aca.homework.week17.website.mapper;

public interface Mapper<E, T> {
    T apply(E value);
}
