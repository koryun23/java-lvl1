package com.aca.homework.week9.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class InvoiceServiceTest {
    private InvoiceService testSubject;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        testSubject = new InvoiceService();
        testSubject.load("invoices.txt");
    }

    @Test
    public void testTotalAmountByTypeSAD() {
        Assertions.assertEquals(2602704070L, testSubject.totalAmountByType(InvoiceType.SAD));
    }

    @Test
    public void testGetBySADType() {
        Invoice[] filteredBySADType = testSubject.getByType(InvoiceType.SAD);
        boolean allTypesAreSAD = true;
        for (Invoice invoice : filteredBySADType) {
            if (invoice.getType() != InvoiceType.SAD) {
                allTypesAreSAD = false;
            }
        }
        Assertions.assertTrue(allTypesAreSAD);
    }

    @Test
    public void testGetByMANType() {
        Invoice[] filteredByMANType = testSubject.getByType(InvoiceType.MAN);
        boolean allTypesAreMAN = true;
        for (Invoice invoice : filteredByMANType) {
            if (invoice.getType() != InvoiceType.MAN) {
                allTypesAreMAN = false;
                break;
            }
        }
        Assertions.assertTrue(allTypesAreMAN);
    }

    @Test
    public void getBySADTypeAndCode() {
        Invoice[] filteredByTypeAndCode = testSubject.getByTypeAndCode(InvoiceType.SAD, "MY-CODE");
        boolean allTypesAreSAD = true;
        boolean allCodesAreMyCode = true;
        for (Invoice invoice : filteredByTypeAndCode) {
            if (invoice.getType() != InvoiceType.SAD) {
                allTypesAreSAD = false;
                break;
            }
            if (!"MY-CODE".equals(invoice.getCode())) {
                allCodesAreMyCode = false;
                break;
            }
        }
        Assertions.assertTrue(allCodesAreMyCode && allTypesAreSAD);
    }
}