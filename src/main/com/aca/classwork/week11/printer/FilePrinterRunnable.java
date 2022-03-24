package com.aca.classwork.week11.printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FilePrinterRunnable implements Runnable{

    private final String filePath;

    public FilePrinterRunnable(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        if(true) throw new RuntimeException();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file " + filePath + " not found");
        }
        for(int i = 0; i < 30_000_000; i++){
            writer.println(i);
        }
        writer.close();
    }
}
