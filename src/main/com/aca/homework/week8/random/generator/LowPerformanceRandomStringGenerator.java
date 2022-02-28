package com.aca.homework.week8.random.generator;

public class LowPerformanceRandomStringGenerator implements RandomStringGenerator {

    @Override
    public Result randomString(int length) {
        long startMillis = System.currentTimeMillis();
        if (!isLengthValid(length)) return Result.resultOf("error", (double) System.currentTimeMillis() - startMillis);
        String text = "";
        for (int i = 0; i < length; i += 3) {
            text += Randomizer.randomString();
        }
        return Result.resultOf(text, (double) System.currentTimeMillis() - startMillis);
    }

    @Override
    public boolean isLengthValid(int length) {
        return length % 3 == 0;
    }
}
