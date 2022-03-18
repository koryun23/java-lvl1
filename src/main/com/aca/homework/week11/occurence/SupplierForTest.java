package com.aca.homework.week11.occurence;

public class SupplierForTest implements Supplier {
    private final String[] inputs;
    private int index;

    public SupplierForTest(String[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public String get() {
        return inputs[index++];
    }
}
