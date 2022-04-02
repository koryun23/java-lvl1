package com.aca.additional.design.patterns.prototype.example2;

public class Client {
    private ProductA productA;
    private ProductB productB;
    private final PrototypeFactory prototypeFactory;

    public Client(PrototypeFactory ptFactory) {
        prototypeFactory = ptFactory;
    }

    public String operation() {
        System.out.println("Client: Delegating object creation to prototype factory.");
        productA = prototypeFactory.createProductA();
        productB = prototypeFactory.createProductB();
        return "Hello world from " + productA.getName() + " and " + productB.getName() + "!";
    }
}
