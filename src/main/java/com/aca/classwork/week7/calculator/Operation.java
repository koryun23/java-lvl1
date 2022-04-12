package com.aca.classwork.week7.calculator;

public enum Operation {
    ADDITION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 + number2;
        }
    },
    SUBTRACTION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MULTIPLICATION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIVISION {
        @Override
        public double calculate(double number1, double number2) {
            return number1 / number2;
        }
    };

    public abstract double calculate(double number1, double number2);

}
