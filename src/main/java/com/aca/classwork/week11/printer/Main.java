package com.aca.classwork.week11.printer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\classwork\\week11\\file\\aca-text-";
        Runnable printerRunnable = new FilePrinterRunnable(filePath);
        long l = System.currentTimeMillis();
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            runnableList.add(new FilePrinterRunnable(filePath + i + ".txt"));
        }

        for (Runnable runnable : runnableList) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        System.out.println((double) (System.currentTimeMillis() - l) / 1000);

    }
}
