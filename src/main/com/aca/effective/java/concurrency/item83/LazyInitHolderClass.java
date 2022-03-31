package com.aca.effective.java.concurrency.item83;

import java.util.Random;

public class LazyInitHolderClass {

    private static class FieldHolder {
        static final String field = computeFieldValue();
    }

    private static String getField(){
        return FieldHolder.field;
    }
    private static String computeFieldValue(){
        return String.valueOf(new Random().nextInt(10));
    }

//    When getField is invoked for the first time, it reads
//    FieldHolder.field for the first time, causing the initialization of the
//    FieldHolder class.
//    The getField method is not synchronized and performs only a field access, so lazy
//    initialization adds practically nothing to the cost of access. A typical VM will
//    synchronize field access only to initialize the class. Once the class is
//    Initialized, the VM patches the code so that subsequent access to the field
//        does not involve any testing or synchronization.

}
