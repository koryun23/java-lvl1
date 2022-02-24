package com.aca.classwork.week7.annotations;

public class StringMakerResult {
    private double executionTime;
    private String output;

    public StringMakerResult(String output, double executionTime) {
        this.executionTime = executionTime;
        this.output = output;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public String getOutput() {
        return output;
    }


}
