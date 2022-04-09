package com.aca.homework.week11.repository.invoice;

import java.util.List;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);

    @Nullable
    Invoice findById(String id);

    List<Invoice> findAll();

    void delete(Invoice invoice);
}
