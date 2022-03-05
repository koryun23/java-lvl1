package com.aca.homework.week9.calculator;

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

    public abstract String performOperation(int num1, int num2);

    public static Operation charToOperation(char ch) {
        switch (ch) {
            case '+':
                return Operation.ADDITION;
            case '-':
                return Operation.SUBTRACTION;
            case '*':
                return Operation.MULTIPLICATION;
            case '/':
                return Operation.DIVISION;
            default:
                return null;
        }
    }

}
