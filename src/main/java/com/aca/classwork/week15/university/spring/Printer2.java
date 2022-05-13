package com.aca.classwork.week15.university.spring;

import org.springframework.stereotype.Component;

@Component(value = "printer2")
public class Printer2 implements Printer {

    @Override
    public void print() {
        System.out.println("printer 2");
    }
}
