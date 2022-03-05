package com.aca.homework.week9.invoice.service;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class InvoiceService {
    private Invoice[] invoices;

    public void load(String filename) throws FileNotFoundException {
        invoices = new InvoiceReader().read(filename);
    }

    public long totalAmountByType(InvoiceType type) {
        long totalAmount = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getType().equals(type)) {
                totalAmount += invoice.getAmount();
            }
        }
        return totalAmount;
    }

    public Invoice[] getByType(InvoiceType type) {
        Invoice[] invoicesFilteredByType = new Invoice[invoices.length];
        int index = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getType() == type) {
                invoicesFilteredByType[index++] = invoice;
            }
        }
        return Arrays.copyOf(invoicesFilteredByType, index);
    }

    public Invoice[] getByTypeAndCode(InvoiceType type, String code) {
        Invoice[] invoicesFilteredByTypeAndCode = new Invoice[invoices.length];
        int index = 0;
        for (Invoice invoice : invoices) {
            if (invoice.getType() == type && invoice.getCode().equals(code)) {
                invoicesFilteredByTypeAndCode[index++] = invoice;
            }
        }
        return Arrays.copyOf(invoicesFilteredByTypeAndCode, index);
    }
}
