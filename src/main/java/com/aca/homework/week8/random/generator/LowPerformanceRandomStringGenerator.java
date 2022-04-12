package com.aca.homework.week8.random.generator;

public class LowPerformanceRandomStringGenerator implements RandomStringGenerator {

    @Override
    public Result randomString(int length) {
        long startMillis = System.currentTimeMillis();
        if (!isLengthValid(length)) return new Result("error", 0);
        String text = "";
        for (int i = 0; i < length; i += 3) {
            text += Randomizer.randomString();
        }
        return new Result(text, System.currentTimeMillis() - startMillis);
    }

    private boolean isLengthValid(int length) {
        return length % 3 == 0;
    }
}
