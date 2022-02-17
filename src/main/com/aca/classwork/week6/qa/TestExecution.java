package com.aca.classwork.week6.qa;

public abstract class TestExecution {

    private final String description;

    public TestExecution(String description) {
        this.description = description;
    }

    public void start() {
        printTestDescription();
        Result result = execute();
        printResult(result);
    }

    public void printTestDescription() {
        System.out.println("Starting test " + description);
    }

    public void printResult(Result result) {
        System.out.println("The result of " + description + " is " + result);
    }

    public abstract Result execute();
}
