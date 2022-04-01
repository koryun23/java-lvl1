package com.aca.homework.week9.invoice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InvoiceReader extends AbstractReader implements Reader<Invoice> {

    private final String filePath;

    public InvoiceReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Invoice> read() {
        List<Invoice> invoices = new LinkedList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File with path " + filePath + " was not found");
        }
        scanner.nextLine();
        while (scanner.hasNext()) {
            invoices.add(fetchInvoiceFromLine(scanner.nextLine()));
        }

        return invoices;
    }
}
