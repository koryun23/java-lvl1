package com.aca.homework.week15.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerMain.class);

    public static void main(String[] args) {
        LOGGER.debug("Hello SLF4J!");
    }
}
