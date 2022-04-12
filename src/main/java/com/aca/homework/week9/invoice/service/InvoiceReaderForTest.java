package com.aca.homework.week9.invoice.service;

import java.util.LinkedList;
import java.util.List;

public class InvoiceReaderForTest extends AbstractReader implements Reader<Invoice> {

    private final List<String> lines;

    public InvoiceReaderForTest(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public List<Invoice> read() {
        List<Invoice> invoices = new LinkedList<>();
        for (String line : lines) {
            invoices.add(fetchInvoiceFromLine(line));
        }
        return invoices;
    }
}
