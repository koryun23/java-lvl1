package com.aca.additional.design.patterns.adapter.example2;

public class Adapter implements Strategy{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String algorithm() {
        return adaptee.specificOperation();
    }
}
