package com.aca.homework.week14.parallel.file.timer;

import java.io.*;

public class TimerRunnable implements Runnable {
    private static final String PATH = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\java\\com\\aca\\homework\\week14\\parallel\\file\\timer";
    private final String fileName;
    private long startTime;
    private ObjectOutputStream objectOutputStream;
    private boolean isInterrupted;
    private final long waitingTimeUntilExecutionStart;

    public TimerRunnable(String fileName, long waitingTime) {
        this.waitingTimeUntilExecutionStart = waitingTime;
        this.fileName = fileName;
        setObjectOutputStream();
    }

    private void setObjectOutputStream() {
        try {
            this.objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH + "\\" + fileName + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not instantiate Object Output Stream");
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waitingTimeUntilExecutionStart);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.startTime = System.currentTimeMillis();

        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("inside run() method " + (System.currentTimeMillis() - startTime) / 1000);
                setObjectOutputStream();
                objectOutputStream.writeLong((System.currentTimeMillis() - startTime) / 1000);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not write elapsed time");
            }
        }
    }

    public synchronized void stop() {
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isInterrupted = true;
    }

    public synchronized boolean isInterrupted() {
        return isInterrupted;
    }

    public String getFilePath() {
        return PATH + "\\" + fileName + ".txt";
    }
}
