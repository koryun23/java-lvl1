package com.aca.homework.week14.parallel.api.test;

public class Test {
    private final TestResult result;
    private final String testName;
    private final String testDescription;

    public Test(TestResult result, String testName, String testDescription) {
        this.result = result;
        this.testName = testName;
        this.testDescription = testDescription;
    }

    public TestResult getResult() {
        return result;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDescription() {
        return testDescription;
    }
}
