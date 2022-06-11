package com.aca.exam.exam3.generator;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableGenerator implements Callable<String> {

    private final List<String> plateNumbers;
    private final String[] numbers;
    private final String letterCombination;
    private final String initialNumberCombination;

    public CallableGenerator(List<String> plateNumbers, String[] numbers, String letterCombination, String initialNumberCombination) {
        this.plateNumbers = plateNumbers;
        this.numbers = numbers;
        this.letterCombination = letterCombination;
        this.initialNumberCombination = initialNumberCombination;
    }

    @Override
    public String call() {
        for (String number : numbers) {
            plateNumbers.add(letterCombination + " " + initialNumberCombination + number);
        }
        return null;
    }
}
