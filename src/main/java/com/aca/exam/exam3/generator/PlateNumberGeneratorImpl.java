package com.aca.exam.exam3.generator;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class PlateNumberGeneratorImpl implements Generator<String> {

    final List<String> plateNumbers = new LinkedList<>();
    final String[] letters = {"A", "B", "C"};
    final String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    final ExecutorService executor = Executors.newCachedThreadPool();

    public List<String> generate() {
        List<String> letterCombinations = new LinkedList<>();
        for (String letter : letters) {
            for (String s : letters) {
                letterCombinations.add(letter + s);
            }
        }

        for (String comb : letterCombinations) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    try {
                        executor.invokeAll(List.of(new CallableGenerator(plateNumbers, numbers, comb, numbers[i] + numbers[j])));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        executor.shutdown();

        return plateNumbers;
    }
}
