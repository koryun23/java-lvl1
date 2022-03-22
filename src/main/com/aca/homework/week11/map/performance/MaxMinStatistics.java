package com.aca.homework.week11.map.performance;

import java.util.Map;

public class MaxMinStatistics {
    private final Map<String, Integer> map;

    private MaxMinStatistics(Map<String, Integer> map) {
        this.map = map;
    }

    public static MaxMinStatistics of(Map<String, Integer> map){
        return new MaxMinStatistics(map);
    }
    public String getMaxOccurredString() {
        int maxOccurredCount = getMaxOccurredCount();
        for (String string : map.keySet()) {
            if (map.get(string) == maxOccurredCount) {
                return string;
            }
        }
        return null;
    }


    public String getMinOccurredString() {
        int minOccurredCount = getMinOccurredCount();
        for (String string : map.keySet()) {
            if (map.get(string) == minOccurredCount) {
                return string;
            }
        }
        return null;
    }

    public int getMaxOccurredCount() {
        int maxOccurredCount = 0;
        for (String string : map.keySet()) {
            if (map.get(string) > maxOccurredCount) {
                maxOccurredCount = map.get(string);
            }
        }
        return maxOccurredCount;
    }

    public int getMinOccurredCount() {
        int minOccurredCount = Integer.MAX_VALUE;
        for (String string : map.keySet()) {
            if (map.get(string) < minOccurredCount) {
                minOccurredCount = map.get(string);
            }
        }
        return minOccurredCount;
    }

    @Override
    public String toString() {
        return String.format(
                "Max occurred string: %s(%o times)\nMin occurred string: %s(%o times)",
                getMaxOccurredString(), getMaxOccurredCount(), getMinOccurredString(), getMinOccurredCount()
        );
    }
}
