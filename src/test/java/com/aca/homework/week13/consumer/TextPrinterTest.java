package com.aca.homework.week13.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TextPrinterTest {

    @Test
    public void testWhenListIsEmpty() {
        PrinterConsumer printerConsumer = new PrinterConsumer();
        new TextPrinter(printerConsumer).printAll(List.of());
        Assertions.assertEquals(0, printerConsumer.getTimesAccessed());
        Assertions.assertEquals(List.of(), printerConsumer.getArgumentsTaken());
    }

    @Test
    public void testWhenListContains1Item() {
        PrinterConsumer printerConsumer = new PrinterConsumer();
        new TextPrinter(printerConsumer).printAll(List.of("1"));
        Assertions.assertEquals(1, printerConsumer.getTimesAccessed());
        Assertions.assertEquals(List.of("1"), printerConsumer.getArgumentsTaken());
    }

    @Test
    public void testWhenListContains2Items() {
        PrinterConsumer printerConsumer = new PrinterConsumer();
        new TextPrinter(printerConsumer).printAll(List.of("1", "2"));
        Assertions.assertEquals(2, printerConsumer.getTimesAccessed());
        Assertions.assertEquals(List.of("1", "2"), printerConsumer.getArgumentsTaken());
    }
}