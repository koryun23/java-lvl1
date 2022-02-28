package com.aca.homework.week8.random.generator;

public class Result {
    private final String text;
    private final double duration;

    private Result(String text, double duration) {
        this.text = text;
        this.duration = duration;
    }

    public static Result resultOf(String text, double duration) {
        return new Result(text, duration);
    }

    public String getText() {
        return text;
    }

    public double getDuration() {
        return duration;
    }
}
