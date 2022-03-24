package com.aca.classwork.week11.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrinterMain {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\classwork\\week11\\file\\aca-text.txt";
        PrintWriter printWriter = new PrintWriter(filename);

        printWriter.print(12);

        printWriter.close();
    }
}
