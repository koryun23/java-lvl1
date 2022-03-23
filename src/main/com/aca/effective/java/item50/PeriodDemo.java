package com.aca.effective.java.item50;

import java.util.Date;

public class PeriodDemo {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setTime(5000); // modified internals of p
    }
}
