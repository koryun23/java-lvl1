package com.aca.homework.week11.unique.cars;

import java.util.function.Supplier;

public class StringSupplierForTest implements Supplier<String> {

    private final String[] inputs;
    private int index = 0;

    public StringSupplierForTest(String[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public String get() {
        return inputs[index++];
    }
}
