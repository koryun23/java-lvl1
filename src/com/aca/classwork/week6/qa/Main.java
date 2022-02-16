package com.aca.classwork.week6.qa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TestExecution[] tests = {new MaximumTestExecution(), new MinimumTestExecution(), new AbsTestExecution()};
        printTestResults(tests);

        System.setErr(new PrintStream(new FileOutputStream("./errors.txt")));
        System.setOut(new PrintStream(new FileOutputStream("./out.txt")));
    }

    public static void printTestResults(TestExecution[] tests) {
        for (TestExecution test : tests) {
            test.start();
        }
    }
}
