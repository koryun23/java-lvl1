package com.aca.homework.week8.random.generator;

public class Result {
    private final String text;
    private final long duration;

    public Result(String text, long duration) {
        this.text = text;
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public long getDuration() {
        return duration;
    }
}
