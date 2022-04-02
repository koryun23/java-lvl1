package com.aca.additional.design.patterns.prototype.example1;

public class Client {
    private final Prototype prototype;
    private Product product;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public String operation() {
        product = prototype.clone();
        return "Client: Cloning " + prototype.getClass().getSimpleName() + ".\n" + product.getName() + " object copied.";
    }
}
