package com.aca.classwork.week7.test;

public enum ResultType {
    FAIL("execution is failed"),
    PASS("execution is passed");

    private String message;
    ResultType(String result){
        this.message = result;
    }

    public String getResult(String name) {
        return name + " " + message;
    }
}
