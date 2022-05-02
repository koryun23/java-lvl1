package com.aca.exam.exam3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlateNumberGenerator {
    static final List<String> plateNumbers = new LinkedList<>();
    static String[] letters = {"A", "B", "C"};
    static String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void generate() {
        // XX YYY

        for(int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                String currentLetterComb = letters[i] + letters[j];
            }
        }

    }

    public static void main(String[] args) {
        generate();
        System.out.println(plateNumbers);
        System.out.println(plateNumbers.size());
    }
}
