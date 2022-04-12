package com.aca.homework.week11.repository.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class HashSetInvoiceRepositoryTest {
    private InvoiceRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HashSetInvoiceRepository();
    }

    @Test
    public void testSaveWhenSetIsEmpty() {
        testSubject.save(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID));
        Assertions.assertEquals(1, testSubject.findAll().size());
    }

    @Test
    public void testSaveWhenExistsWithSameIdButNewFieldsAreDifferent() {
        testSubject.save(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID));
        testSubject.save(new Invoice("invoice-1", 300, InvoiceStatus.PAID));
        Assertions.assertEquals(1, testSubject.findAll().size());
        Assertions.assertEquals(new Invoice("invoice-1", 300, InvoiceStatus.PAID), testSubject.findById("invoice-1"));
    }

    @Test
    public void testSave2Times() {
        testSubject.save(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID));
        testSubject.save(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID));
        Assertions.assertEquals(1, testSubject.findAll().size());
        Assertions.assertEquals(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID), testSubject.findById("invoice-1"));
    }

    @Test
    public void testFindByIdWhenNotFound() {
        Assertions.assertNull(testSubject.findById("invoice-1"));
    }

    @Test
    public void testFindByIdWhenFound() {
        testSubject.save(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID));
        Assertions.assertEquals(new Invoice("invoice-1", 500, InvoiceStatus.UNPAID), testSubject.findById("invoice-1"));
    }

    @Test
    public void testFindAllWhenEmpty() {
        Assertions.assertEquals(0, testSubject.findAll().size());
    }

    @Test
    public void testDeleteWhenEmpty() {
        Assertions.assertEquals(0, testSubject.findAll().size());
        testSubject.delete(new Invoice("invoice-1", 100, InvoiceStatus.UNPAID));
        Assertions.assertEquals(0, testSubject.findAll().size());
    }

    @Test
    public void testDeleteWhenExists() {
        testSubject.save(new Invoice("invoice-1", 100, InvoiceStatus.PAID));
        testSubject.delete(new Invoice("invoice-1", 100, InvoiceStatus.PAID));
        Assertions.assertEquals(0, testSubject.findAll().size());
        Assertions.assertNull(testSubject.findById("invoice-1"));
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThrows(NullIdException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.findById(null);
            }
        });
    }
}