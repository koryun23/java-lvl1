package com.aca.homework.week8.checked.unchecked.exceptions;

public class Main {
    public static void main(String[] args) {
        // stack = [main]
        try {
            method1(); // stack = [main, method1]
        } catch (Exception e) {
            System.out.println("catch");
        }
        System.out.println("finished");
    }

    public static void method1() {
        method2(); // stack = [main, method1, method2]
    }

    public static void method2() {
        method3(); // stack = [main, method1, method2, method3]
    }

    public static void method3() {
        try {
            method4(); // stack = [main, method1, method2, method3, method4]
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void method4() throws Exception {
        method5(); // stack = [main, method1, method2, method3, method4, method5]
    }

    public static void method5() throws Exception {
        throw new Exception();
    }
}
