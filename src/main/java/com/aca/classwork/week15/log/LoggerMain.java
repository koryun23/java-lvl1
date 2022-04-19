package com.aca.classwork.week15.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.aca.homework.week15.log.LoggerMain.class);

    public static void main(String[] args) {
        max(5, 10);
    }

    public static int max(int a, int b) {
        LOGGER.debug("Calculating maximum between numbers a {} and b {}", a, b);
        return a > b ? a : b;
    }
}
