package com.aca.homework.week9.invoice.service;

import java.util.List;

public abstract class AbstractReader implements Reader<Invoice> {
    public static Invoice fetchInvoiceFromLine(String line) {
        String[] invoiceItems = line.split(",");
        return new Invoice(
                getIdFromLine(invoiceItems),
                getAmountFromLine(invoiceItems),
                getTypeFromLine(invoiceItems),
                getCodeFromLine(invoiceItems)
        );
    }

    private static String getIdFromLine(String[] params) {
        return params[0];
    }

    private static int getAmountFromLine(String[] params) {
        return Integer.parseInt(params[1]);
    }

    private static InvoiceType getTypeFromLine(String[] params) {
        return "SAD".equals(params[2]) ? InvoiceType.SAD : InvoiceType.MAN;
    }

    private static String getCodeFromLine(String[] params) {
        return params[3];
    }

    @Override
    public abstract List<Invoice> read();
}
