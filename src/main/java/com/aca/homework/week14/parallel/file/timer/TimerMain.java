package com.aca.homework.week14.parallel.file.timer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class TimerMain {

    private final Supplier<String> fileNameSupplier;
    private final Supplier<Long> waitingTimeSupplier;
    private static final String PATH = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\java\\com\\aca\\homework\\week14\\parallel\\file\\timer";


    public TimerMain(Supplier<String> fileNameSupplier, Supplier<Long> sleepTimeSupplier) {
        this.fileNameSupplier = fileNameSupplier;
        this.waitingTimeSupplier = sleepTimeSupplier;
    }

    public void start() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<TimerRunnable>> callables = new LinkedList<>();
        for(int i = 0; i < 2; i++) {
            callables.add(() -> new TimerRunnable(fileNameSupplier.get(), waitingTimeSupplier.get()));
        }

        try {
            executor.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TimerMain(
                new FileNameSupplier(List.of("timer1, timer2, timer1, timer2")),
                new SleepTimeSupplier(List.of(2500L, 3200L, 0L, 0L))
        ).start();

        try {
            FileReader fileReaderTimer1 = new FileReader(new ObjectInputStream(new FileInputStream(PATH + "\\timer1.txt")));
            System.out.println(fileReaderTimer1.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReaderTimer2 = new FileReader(new ObjectInputStream(new FileInputStream(PATH + "\\timer2.txt")));
            System.out.println(fileReaderTimer2.read());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
