package com.aca.additional.design.patterns.prototype.example2;

public class ProductB1 implements ProductB {

    private final String name;

    public ProductB1(String name) {
        this.name = name;
    }

    public ProductB1(ProductB1 pb) {
        name = pb.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ProductB clone() {
        return new ProductB1(this);
    }
}
