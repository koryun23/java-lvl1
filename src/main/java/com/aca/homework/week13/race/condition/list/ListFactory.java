package com.aca.homework.week13.race.condition.list;

import java.util.function.Supplier;

public class ListFactory {

    private final Supplier<Boolean> supplier;

    public ListFactory(Supplier<Boolean> supplier) {
        this.supplier = supplier;
    }

    public List<Integer> getList() {
        return supplier.get() ? new SafeList<>() : new UnsafeList<>();
    }
}