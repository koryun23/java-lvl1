package com.aca.homework.week11.repository.invoice;

import java.util.Objects;

public class Invoice {
    private String id;
    private double amountToPay;
    private InvoiceStatus status;

    public Invoice(@NotNull String id, double amountToPay, @NotNull InvoiceStatus status) {
        setId(id);
        setAmountToPay(amountToPay);
        setInvoiceStatus(status);
    }

    public void setId(String id) {
        if(id == null)
            throw new IllegalArgumentException("Id must be non-null");
        this.id = id;
    }

    public void setAmountToPay(double amountToPay) {
        if(amountToPay < 0)
            throw new IllegalArgumentException("Amount ot pay must be >= 0.0");
        this.amountToPay = amountToPay;
    }

    public void setInvoiceStatus(InvoiceStatus status) {
        if(status == null)
            throw new IllegalArgumentException("Invoice status must be non-null");
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
