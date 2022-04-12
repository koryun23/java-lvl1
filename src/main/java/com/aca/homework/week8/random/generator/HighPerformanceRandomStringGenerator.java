package com.aca.homework.week8.random.generator;

public class HighPerformanceRandomStringGenerator implements RandomStringGenerator {
    @Override
    public Result randomString(int length) {
        long startMillis = System.currentTimeMillis();
        if (!isLengthValid(length)) return new Result("error", 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i += 3) {
            sb.append(Randomizer.randomString());
        }
        return new Result(sb.toString(), System.currentTimeMillis() - startMillis);
    }

    private boolean isLengthValid(int length) {
        return length % 3 == 0;
    }
}
