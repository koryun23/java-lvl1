package com.aca.homework.week11.map.performance;

import java.util.Random;

public class Randomizer {
    private static final char[] chars = {'a', 'b', 'c', 'd', 'e'};
    private static final int size = 8;

    private Randomizer(){}

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(chars[generator.nextInt(chars.length)]);
        }

        return sb.toString();
    }
}
