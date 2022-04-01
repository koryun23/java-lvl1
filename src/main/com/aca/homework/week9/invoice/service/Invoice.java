package com.aca.homework.week9.invoice.service;

import java.util.Objects;

public class Invoice {
    private final String id;
    private final int amount;
    private final InvoiceType type;
    private final String code;

    public Invoice(String id, int amount, InvoiceType type, String code) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public InvoiceType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("INVOICE[id = %d, amount = %d, type = %s, code = %s]", id, amount, type, code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return amount == invoice.amount && Objects.equals(id, invoice.id) && type == invoice.type && Objects.equals(code, invoice.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, type, code);
    }
}
