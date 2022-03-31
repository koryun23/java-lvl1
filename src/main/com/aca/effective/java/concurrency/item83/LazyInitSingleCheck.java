package com.aca.effective.java.concurrency.item83;

import java.util.Random;

public class LazyInitSingleCheck { // can cause multiple initialization
    private volatile String field;

    private String getField(){
        String result = field;
        if(result == null) {
            field = result = computeFieldValue();
        }
        return result;
    }

    private static String computeFieldValue(){
        return String.valueOf(new Random().nextInt(10));
    }

}
