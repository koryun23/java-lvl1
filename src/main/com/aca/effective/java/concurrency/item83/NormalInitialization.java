package com.aca.effective.java.concurrency.item83;

import java.util.Random;

public class NormalInitialization {
    private final String field = computeFieldValue(); // normal initialization of an instance field


    private String computeFieldValue(){
        return String.valueOf(new Random().nextInt(10));
    }
}
