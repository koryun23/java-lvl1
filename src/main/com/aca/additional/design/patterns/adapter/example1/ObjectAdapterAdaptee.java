package com.aca.additional.design.patterns.adapter.example1;

public class ObjectAdapterAdaptee implements Target {

    private final Adaptee adaptee;

    public ObjectAdapterAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String operation() {
        return adaptee.specificOperation();
    }
}
