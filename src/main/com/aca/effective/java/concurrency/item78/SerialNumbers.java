package com.aca.effective.java.concurrency.item78;

public class SerialNumbers {
    private static volatile int nextSerialNumber = 0;

    public static int generateNextSerialNumber(){
        return nextSerialNumber++;
    }

    // The method will not work properly without synchronization.
    // The problem is that ++ is not atomic. It performs 2 operations on the nextSerialNumber field: first reads
    // the value and then it writes back a new value. If a second thread reads the field between the time a thread reads
    // the old value and writes back a new one, the program will not work properly. This is safety failure: The program
    // computes the wrong results.
}
