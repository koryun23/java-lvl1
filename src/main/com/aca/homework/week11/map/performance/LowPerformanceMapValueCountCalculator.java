package com.aca.homework.week11.map.performance;

import java.util.HashMap;
import java.util.Map;

public class LowPerformanceMapValueCountCalculator implements MapValueCountCalculator {

    private final Map<String, Integer> map = new HashMap<>();

    @Override
    public MaxMinStatistics populateAndCalculate(int numberOfRandomStrings) {
        for (int i = 0; i < numberOfRandomStrings; i++) {
            String str = Randomizer.generate();
            modifyHashMap(str);
        }
        return MaxMinStatistics.of(map);
    }

    public void modifyHashMap(String str) {
        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
    }
}
