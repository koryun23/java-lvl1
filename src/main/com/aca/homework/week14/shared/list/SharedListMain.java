package com.aca.homework.week14.shared.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SharedListMain {

    public int start() {
        List<Integer> sharedList = Collections.synchronizedList(new LinkedList<>());
        List<Thread> threadList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new NumberAdderRunnable(i, sharedList));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sharedList.size();

    }
}
