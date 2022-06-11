package com.aca.homework.week11.car.wash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryForTest implements CarRepository {

    private final Map<String, Integer> timesWashedPerCar = new HashMap<>();
    private final String name;
    private String[] inputs;

    public CarRepositoryForTest(String name) {
        this.name = name;
    }

    public void wash() {
        for (String input : inputs) {
            if (timesWashedPerCar.containsKey(input)) {
                timesWashedPerCar.put(input, (timesWashedPerCar.get(input) + 1) % 5);
            } else {
                timesWashedPerCar.put(input, 1);
            }
        }
    }

    public String name() {
        return name;
    }

    @Override
    public void save(Object data) {
        inputs = (String[]) data;
    }

    @Override
    public Object load() {
        return timesWashedPerCar;
    }
}
