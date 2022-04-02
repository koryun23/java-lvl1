package com.aca.additional.design.patterns.prototype.example1;

public class Product1 implements Product, Prototype {

    private final String name;

    public Product1(String name) {
        this.name = name;
    }

    // copy constructor
    public Product1(Product1 p) {
        name = p.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Product clone() {
        return new Product1(this);
    }
}
