package com.aca.homework.week9.invoice.service;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InvoiceService {

    private final Reader<Invoice> invoiceReader;
    private List<Invoice> invoices;

    public InvoiceService(Reader<Invoice> invoiceReader) {
        this.invoiceReader = invoiceReader;
    }

    public void load() {
        invoices = invoiceReader.read();
    }

    public long totalAmountByType(InvoiceType type) {
        long sum = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getType() == type) {
                sum += invoice.getAmount();
            }
        }

        return sum;
    }

    public List<Invoice> getByType(InvoiceType type) {
        List<Invoice> invoices = new LinkedList<>();
        for (Invoice invoice : this.invoices) {
            if (invoice.getType() == type) {
                invoices.add(invoice);
            }
        }
        return invoices;
    }

    public List<Invoice> getByTypeAndCode(InvoiceType type, String code) {
        List<Invoice> invoices = new LinkedList<>();
        for (Invoice invoice : this.invoices) {
            if (invoice.getType() == type && invoice.getCode().equals(code)) {
                invoices.add(invoice);
            }
        }
        return invoices;
    }

}
