package com.aca.homework.week15.repository.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeRepositoryIntegrationTest {

    private CrudRepository<Employee, String> testSubject;

    @BeforeEach
    public void init() {
        testSubject = new EmployeeRepository(new ConnectionFactory());
    }

    @Test
    public void testInsert() {
        testSubject.save(new Employee("id-1", "John", "Brown", 10000L));
        Employee empl = testSubject.findById("id-1");
        Assertions.assertEquals("id-1", empl.getId());
        Assertions.assertEquals("John", empl.getFirstName());
        Assertions.assertEquals("Brown", empl.getSecondName());
        Assertions.assertEquals(10000L, empl.getSalary());
    }
}