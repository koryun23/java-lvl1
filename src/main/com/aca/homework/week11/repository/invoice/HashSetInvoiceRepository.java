package com.aca.homework.week11.repository.invoice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetInvoiceRepository implements InvoiceRepository {

    private final Set<Invoice> invoices;

    public HashSetInvoiceRepository() {
        invoices = new HashSet<>();
    }

    @Override
    public Invoice save(Invoice invoice) {
        if (invoice == null)
            throw new NullInvoiceException();
        invoices.add(invoice);
        return invoice;
    }

    @Override
    public Invoice findById(String id) {
        if (id == null)
            throw new NullIdException();
        for (Invoice invoice : invoices) {
            if (id.equals(invoice.getId())) {
                return invoice;
            }
        }
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        return List.copyOf(invoices);
    }

    @Override
    public void delete(Invoice invoice) {
        invoices.remove(invoice);
    }
}
