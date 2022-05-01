package com.aca.homework.week15.repository.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeRepositoryIntegrationTest {

    private CrudRepository<Employee, String> testSubject;

    @BeforeEach
    public void init() {
        testSubject = new EmployeeRepository(new ConnectionFactory());
    }


    @Test
    public void testInsertAndFindById() {
        testSubject.deleteAll();
        testSubject.save(new Employee("id-1", "John", "Brown", 10000L));
        Employee empl = testSubject.findById("id-1");
        Assertions.assertEquals("id-1", empl.getId());
        Assertions.assertEquals("John", empl.getFirstName());
        Assertions.assertEquals("Brown", empl.getSecondName());
        Assertions.assertEquals(10000L, empl.getSalary());
        testSubject.deleteAll();
    }

    @Test
    public void testDelete() {
        testSubject.deleteAll();
        testSubject.save(new Employee("id-1", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-2", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-3", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-4", "John", "Brown", 10000L));

        testSubject.deleteAll();
        Assertions.assertEquals(0, testSubject.findAll().size());
    }

    @Test
    public void testFindAll() {
        testSubject.deleteAll();
        testSubject.save(new Employee("id-1", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-2", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-3", "John", "Brown", 10000L));
        testSubject.save(new Employee("id-4", "John", "Brown", 10000L));

        Assertions.assertEquals(List.of(
                new Employee("id-1", "John", "Brown", 10000L),
                new Employee("id-2", "John", "Brown", 10000L),
                new Employee("id-3", "John", "Brown", 10000L),
                new Employee("id-4", "John", "Brown", 10000L)
        ), testSubject.findAll());
    }
}