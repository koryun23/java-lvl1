package com.aca.homework.week9.invoice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InvoiceReader {
    public Invoice[] read(String filename) throws FileNotFoundException {
        Invoice[] invoices = new Invoice[countLinesOfFile(filename) - 1];
        int index = 0;
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\homework\\week9\\invoice\\service\\" + filename));
        scanner.nextLine(); // to omit the first line of the file
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String[] arrayOfInvoiceItems = nextLine.split(",");
            Invoice invoice = new Invoice(
                    arrayOfInvoiceItems[0],
                    Long.parseLong(arrayOfInvoiceItems[1]),
                    InvoiceType.valueOf(arrayOfInvoiceItems[2]),
                    arrayOfInvoiceItems[3]
            );
            invoices[index++] = invoice;
        }
        return invoices;
    }

    private int countLinesOfFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\homework\\week9\\invoice\\service\\" + filename));
        int countOfLines = 0;
        while (scanner.hasNextLine()) {
            countOfLines++;
            scanner.nextLine();
        }
        return countOfLines;
    }
}
