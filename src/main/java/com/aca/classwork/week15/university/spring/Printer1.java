package com.aca.classwork.week15.university.spring;

import org.springframework.stereotype.Component;

@Component(value = "defaultPrinter")
public class Printer1 implements Printer {
    @Override
    public void print() {
        System.out.println("printer 1");
    }
}
