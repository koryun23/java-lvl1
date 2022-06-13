package com.aca.homework.week17.website.entity;

public class NegativeImageCountException extends RuntimeException {
    public NegativeImageCountException(int actualNumber) {
        super("Image count of a post cannot be negative: actual count - " + actualNumber);
    }
}
