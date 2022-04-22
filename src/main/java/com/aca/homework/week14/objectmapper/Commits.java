package com.aca.homework.week14.objectmapper;

import java.util.Arrays;

public class Commits {
    private int total;
    private int week;
    private int[] days;

    public Commits() {
    }

    public Commits(int total, int week, int[] days) {
        this.total = total;
        this.week = week;
        this.days = days;
    }

    public int getTotal() {
        return total;
    }

    public int getWeek() {
        return week;
    }

    public int[] getDays() {
        return days;
    }

    @Override
    public String toString() {
        return String.format("COMMIT[total=%d, week=%d, days=%s]", total, week, Arrays.toString(days));
    }
}
