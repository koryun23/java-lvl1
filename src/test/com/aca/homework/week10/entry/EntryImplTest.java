package com.aca.homework.week10.entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryImplTest {
    private Entry<String, Integer> entry;

    @BeforeEach
    public void setUp() {
        entry = new EntryImpl<>("abc", 45);
    }

    @Test
    public void testKeyGetter() {
        Assertions.assertEquals("abc", entry.key());
    }

    @Test
    public void testValueGetter() {
        Assertions.assertEquals(45, entry.value());
    }
}