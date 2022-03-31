package com.aca.effective.java.concurrency.item83;

import java.util.Random;

public class LazyInitInstanceField {
    private String field; // lazy initialization with a synchronized accessor

    private synchronized String getField(){
        if(field == null)
            field = computeFieldValue();
        return field;
    }

    private String computeFieldValue(){
        return String.valueOf(new Random().nextInt(10));
    }
}
