package com.aca.homework.week11.repository.invoice;

import java.util.Objects;

public class Invoice {
    private final String id;
    private final double amountToPay;
    private final InvoiceStatus status;

    public Invoice(String id, double amountToPay, InvoiceStatus status) {
        this.id = id;
        this.amountToPay = amountToPay;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id);
    }

    @Override
    public String toString() {
        return String.format(
                "INVOICE[id = %s, amount to pay = %.2f, invoice status = %s]",
                id, amountToPay, status
        );
    }
}
