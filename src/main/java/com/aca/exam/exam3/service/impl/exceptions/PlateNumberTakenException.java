package com.aca.exam.exam3.service.impl.exceptions;

public class PlateNumberTakenException extends RuntimeException {
    public PlateNumberTakenException(String plateNumber) {
        super("plate with plate number " + plateNumber + " is already taken.");
    }
}
