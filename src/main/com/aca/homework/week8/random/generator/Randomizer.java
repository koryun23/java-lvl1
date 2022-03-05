package com.aca.homework.week8.random.generator;

import java.util.Random;

public class Randomizer {
    private static final char[] symbols = {'a', 'b', '7', '1', '9', '-'};

    public static String randomString() {
        StringBuilder sb = new StringBuilder();
        Random generator = new Random();
        for (int i = 0; i < 3; i++) {
            int index = generator.nextInt(symbols.length);
            char ch = symbols[index];
            sb.append(ch);
        }

        return sb.toString();
    }

}
