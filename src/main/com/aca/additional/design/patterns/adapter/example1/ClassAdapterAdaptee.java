package com.aca.additional.design.patterns.adapter.example1;

public class ClassAdapterAdaptee extends Adaptee implements Target {

    @Override
    public String operation() {
        return specificOperation();
    }
}
