package com.aca.homework.week8.checked.unchecked.exceptions;

public class Main {
    public static void main(String[] args) throws Exception {
        method1();
        try{
           method3();
        } catch(RuntimeException e) {
            System.out.println("catch");
        }
        System.out.println("finished");
    }
    public static void method1() throws Exception {
        method2();
    }
    public static void method2() throws Exception {
        method3();
    }

    public static void method3() throws Exception {
        try{
            method4();
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void method4() throws Exception {
        method5();
    }
    public static void method5() throws Exception{
        throw new Exception();
    }


}
