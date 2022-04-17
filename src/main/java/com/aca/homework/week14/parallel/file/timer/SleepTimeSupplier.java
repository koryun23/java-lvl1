package com.aca.homework.week14.parallel.file.timer;

import java.util.List;
import java.util.function.Supplier;

public class SleepTimeSupplier implements Supplier<Long> {

    private List<Long> sleepTimes;
    private int index;

    public SleepTimeSupplier(List<Long> sleepTimes) {
        this.sleepTimes = sleepTimes;
    }

    @Override
    public Long get() {
        return sleepTimes.get(index++);
    }
}
