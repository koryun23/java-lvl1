package com.aca.homework.week15.sql.generate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SqlGeneratorTest {
    private SqlGenerator testSubject;

    @BeforeEach
    public void init() {
        testSubject = new SqlGenerator();
    }

    @Test
    public void testGenerateInsert() {
        Assertions.assertEquals("\"insert into users (full_name, age) values ('John Kehoe', 45);\"",
                testSubject.generateInsert(new User("John Kehoe", 45)));
    }

}