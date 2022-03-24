package com.aca.homework.week11.unique.cars;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String input) {
        super("Invalid input: " + input + ": The input must contain 3 strings separated with a space.");
    }
}
