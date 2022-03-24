package com.aca.homework.week11.repository.invoice;

public class NullInvoiceException extends RuntimeException {
    public NullInvoiceException() {
        super("Provided invoice is null.");
    }
}
