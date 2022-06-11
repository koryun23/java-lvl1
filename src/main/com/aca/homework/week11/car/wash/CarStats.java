package com.aca.homework.week11.car.wash;

import java.util.HashMap;
import java.util.Map;

public class CarStats {
    private Map<String, Integer> map;

    public CarStats(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}
