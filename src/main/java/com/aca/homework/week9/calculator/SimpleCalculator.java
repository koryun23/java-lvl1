package com.aca.homework.week9.calculator;

public class SimpleCalculator {

    private final StringSupplier supplier;

    public SimpleCalculator(StringSupplier supplier) {
        this.supplier = supplier;
    }

    public String askAndCalculate() {
        System.out.println("Enter an expression in a format [digit][operation][digit]");
        String expression = this.supplier.get();

        if (!isValidExpression(expression)) {
            System.out.println("error");
            return "error";
        }

        int firstDigit = getDigitFromChar(expression.charAt(0));
        int secondDigit = getDigitFromChar(expression.charAt(2));
        char operation = expression.charAt(1);
        return Operation.of(operation).performOperation(firstDigit, secondDigit);
    }

    public boolean isValidExpression(String expression) {
        return expression.length() == 3 &&
                Operation.isDigit(expression.charAt(0)) &&
                Operation.isDigit(expression.charAt(2)) &&
                Operation.isOperation(expression.charAt(1));
    }

    public int getDigitFromChar(char ch) {
        return ch - 48;
    }
}
