package com.aca.homework.week9.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class InvoiceServiceTest {
    private InvoiceService testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new InvoiceService(new InvoiceReaderForTest(List.of(
                "SAD2022-87456,544611032,SAD,MY-CODE",
                "SAD2022-e4459,259880314,SAD,GUCE-CUSTOMS",
                "MAN2022-4660e,206727,MAN,PCS-HDL-BT",
                "SAD2022-a6c3e,35751674,SAD,GUCE-CUSTOMS",
                "MAN2022-920fe,44190,MAN,PCS-HDL-BT"
        )));
        testSubject.load();
    }

    @Test
    public void testTotalAmountByTypeSAD() {
        Assertions.assertEquals(840243020, testSubject.totalAmountByType(InvoiceType.SAD));
    }

    @Test
    public void testGetBySADType() {
        Assertions.assertEquals(List.of(
                new Invoice("SAD2022-87456", 544611032, InvoiceType.SAD, "MY-CODE"),
                new Invoice("SAD2022-e4459", 259880314, InvoiceType.SAD, "GUCE-CUSTOMS"),
                new Invoice("SAD2022-a6c3e", 35751674, InvoiceType.SAD, "GUCE-CUSTOMS")
        ), testSubject.getByType(InvoiceType.SAD));
    }

    @Test
    public void testGetByMANType() {
        Assertions.assertEquals(List.of(
                new Invoice("MAN2022-4660e", 206727, InvoiceType.MAN, "PCS-HDL-BT"),
                new Invoice("MAN2022-920fe", 44190, InvoiceType.MAN, "PCS-HDL-BT")
        ), testSubject.getByType(InvoiceType.MAN));
    }

    @Test
    public void testGetBySADTypeAndCode() {
        Assertions.assertEquals(List.of(
                new Invoice("SAD2022-87456", 544611032, InvoiceType.SAD, "MY-CODE")
        ), testSubject.getByTypeAndCode(InvoiceType.SAD, "MY-CODE"));
    }
}