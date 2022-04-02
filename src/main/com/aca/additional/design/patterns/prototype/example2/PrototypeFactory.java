package com.aca.additional.design.patterns.prototype.example2;

public class PrototypeFactory {
    private final ProductA productA;
    private final ProductB productB;

    public PrototypeFactory(ProductA productA, ProductB productB) {
        this.productA = productA;
        this.productB = productB;
    }

    public ProductA createProductA() {
        System.out.println("PrototypeFactory: Cloning a ProductA object");
        return productA.clone();
    }

    public ProductB createProductB() {
        System.out.println("PrototypeFactory: Cloning a ProductB object");
        return productB.clone();
    }
}
