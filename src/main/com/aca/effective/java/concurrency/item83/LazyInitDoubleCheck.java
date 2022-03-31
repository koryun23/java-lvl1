package com.aca.effective.java.concurrency.item83;

import java.util.Random;

public class LazyInitDoubleCheck {
    private volatile String field;

    private String getField(){
        String result = field;
        if(result == null) { // first check with no locking
            synchronized(this) {
                if(field == null){ // second check with locking
                    field = result = computeFieldValue();
                }
            }
        }
        return result;
    }

    private static String computeFieldValue(){
        return String.valueOf(new Random().nextInt(10));
    }

}
