package com.aca.homework.week9.calculator;

public class SimpleCalculator {
    private final StringSupplier supplier;

    public SimpleCalculator(StringSupplier supplier){
        this.supplier = supplier;
    }

    public String askAndCalculate(){
        System.out.println("Enter an expression in a format [digit][operation][digit]");
        String expression = this.supplier.get();

        if(!isValidExpression(expression)){
            System.out.println("error");
            return "error";
        }

        int firstDigit = getDigitFromChar(expression.charAt(0));
        int secondDigit = getDigitFromChar(expression.charAt(2));
        char operation = expression.charAt(1);
        switch(operation){
            case '+': return String.valueOf(firstDigit + secondDigit);
            case '-': return String.valueOf(firstDigit - secondDigit);
            case '*': return String.valueOf(firstDigit * secondDigit);
            case '/': return String.valueOf((double) firstDigit / secondDigit);
            default: return "error";
        }
    }

    public boolean isValidExpression(String expression){
        return expression.length() == 3 && isDigit(expression.charAt(0)) && isDigit(expression.charAt(2)) && isDigit(expression.charAt(1));
    }

    public boolean isOperation(char ch){
        return ch == '/' || ch == '+' || ch == '-' || ch == '*';
    }

    public boolean isDigit(char ch){
        return ch - 48 <= 9;
    }

    public int getDigitFromChar(char ch){
        return ch - 48;
    }
}
