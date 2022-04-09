package com.aca.classwork.week13.buffer;

public class WaitMain {
    public static void main(String[] args) throws InterruptedException {
        WaitMain waitMain = new WaitMain();
        waitMain.wait(); // throws an exception because the lock is not in our hands
        waitMain.notifyAll(); // throws an exception because the lock is not in our hands
    }
}