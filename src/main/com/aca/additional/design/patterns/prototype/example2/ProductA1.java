package com.aca.additional.design.patterns.prototype.example2;

public class ProductA1 implements ProductA {

    private final String name;

    public ProductA1(String name) {
        this.name = name;
    }

    public ProductA1(ProductA1 pa) {
        name = pa.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ProductA clone() {
        return new ProductA1(this);
    }
}
