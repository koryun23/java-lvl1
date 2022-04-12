package com.aca.homework.week11.repository.invoice;

public class NullIdException extends RuntimeException {
    public NullIdException() {
        super("Provided id is null");
    }
}
