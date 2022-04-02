package com.aca.additional.design.patterns.adapter.example1;

public class Client {
    public static void main(String[] args) {
        Target objectAdapter = new ObjectAdapterAdaptee(new Adaptee());
        System.out.println("(1) " + objectAdapter.operation());

        Target classAdapter = new ClassAdapterAdaptee();
        System.out.println("(2) " + classAdapter.operation());
    }
}
