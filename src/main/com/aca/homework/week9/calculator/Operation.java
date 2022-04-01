package com.aca.homework.week9.calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADDITION('+') {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 + num2);
        }
    },
    SUBTRACTION('-') {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 - num2);
        }
    },
    MULTIPLICATION('*') {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 * num2);
        }
    },
    DIVISION('/') {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf((double) num1 / num2);
        }
    };

    private final char operation;

    Operation(char operation) {
        this.operation = operation;
    }

    public static Operation of(char ch) {
        for (Operation value : Operation.values()) {
            if (value.getOperation() == ch) {
                return value;
            }
        }
        return null;
    }

    public static boolean isOperation(char ch) {
        for (Operation value : Operation.values()) {
            if (value.getOperation() == ch) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDigit(char ch) {
        return ch - 48 <= 9;
    }

    public char getOperation() {
        return operation;
    }

    public abstract String performOperation(int num1, int num2);

}
