package com.aca.homework.week13.entity.info;

public class EntityProcessor {
    public static void main(String[] args) {
        new EntityProcessor().printInfo(new Product(10L, "box"));
    }

    public String getInfo(Object o) {
        return new StrategyFactory().getStrategy(o).print();
    }

    public void printInfo(Object o) {
        System.out.println(getInfo(o));
    }
}
