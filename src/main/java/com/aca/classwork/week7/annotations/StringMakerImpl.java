package com.aca.classwork.week7.annotations;

@LowPerformance
public class StringMakerImpl implements StringMaker {
    @Override
    public StringMakerResult make(int start, int end) {
        long startTime = System.currentTimeMillis();
        String output = "";
        for (int i = start; i < end; i++) {
            output += i;
        }
        return new StringMakerResult(output, (double) (System.currentTimeMillis() - startTime) / 1000);
    }
}
