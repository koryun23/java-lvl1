package com.aca.homework.week9.calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADDITION {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 + num2);
        }
    },
    SUBTRACTION {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 - num2);
        }
    },
    MULTIPLICATION {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf(num1 * num2);
        }
    },
    DIVISION {
        @Override
        public String performOperation(int num1, int num2) {
            return String.valueOf((double) num1 / num2);
        }
    };

    private static final Map<Character, Operation> map = Map.of('+', Operation.ADDITION, '-', Operation.SUBTRACTION, '*', Operation.MULTIPLICATION, '/', Operation.DIVISION);

    public static Operation of(char ch) {
        return map.get(ch);
    }

    public static boolean isOperation(char ch) {
        return map.containsKey(ch);
    }


    public static boolean isDigit(char ch) {
        return ch - 48 <= 9;
    }
    public abstract String performOperation(int num1, int num2);

}
