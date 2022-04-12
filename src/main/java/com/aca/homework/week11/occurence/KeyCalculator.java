package com.aca.homework.week11.occurence;

import java.util.HashMap;
import java.util.Map;

public class KeyCalculator {

    private final Map<Integer, Integer> mapOfOccurrences = new HashMap<>();
    private final Supplier supplier;

    public KeyCalculator(Supplier supplier) {
        this.supplier = supplier;
    }

    public static boolean isEnd(String input) {
        return "end".equals(input);
    }

    public Map<Integer, Integer> getOccurrences() {
        String input;
        while (true) {
            input = supplier.get();
            if (isEnd(input)) {
                break;
            }
            modifyHashMap(input);
        }
        System.out.println(mapOfOccurrences);
        return mapOfOccurrences;
    }

    public void modifyHashMap(String input) {
        Integer number = Integer.parseInt(input);
        if (mapOfOccurrences.containsKey(number)) {
            mapOfOccurrences.put(number, mapOfOccurrences.get(number) + 1);
        } else {
            mapOfOccurrences.put(number, 1);
        }
    }
}
