package com.aca.homework.week10.user.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserRepositoryTest {
    private CrudRepository<User> crud;

    @BeforeEach
    public void setUp() {
        crud = new UserRepository();
    }

    @Test
    public void testSaveWhenUserIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                crud.save(null);
            }
        });
    }

    @Test
    public void testSaveWhenUserDoesNotExist() {
        crud.save(new User(1, "john-123", "John"));
        Assertions.assertEquals(1, crud.count());
        Assertions.assertEquals(1, crud.findById(1).getId());
        Assertions.assertEquals("john-123", crud.findById(1).getUsername());
        Assertions.assertEquals("John", crud.findById(1).getFirstName());
    }

    @Test
    public void testSaveWhenUserExists() {
        crud.save(new User(1, "john-123", "John"));
        crud.save(new User(1, "john-123", "John"));
        Assertions.assertEquals(1, crud.count());
        Assertions.assertEquals(1, crud.findById(1).getId());
        Assertions.assertEquals("john-123", crud.findById(1).getUsername());
        Assertions.assertEquals("John", crud.findById(1).getFirstName());
    }

    @Test
    public void testDeleteWhenEntityNotFound() {
        Assertions.assertThrows(EntityNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                crud.delete(new User(1, "a", "b"));
            }
        });
    }

    @Test
    public void testDelete() {
        crud.save(new User(1, "a", "b"));
        crud.delete(new User(1, "a", "b"));
        Assertions.assertEquals(0, crud.count());
    }

    @Test
    public void testFindByIdWhenDoesNotFound() {
        crud.save(new User(1, "a", "b"));
        Assertions.assertNull(crud.findById(2));
    }

    @Test
    public void testCountWhenRepositoryIsEmpty() {
        Assertions.assertEquals(0, crud.count());
    }

    @Test
    public void testCountWhenRepositoryContains2Entities() {
        crud.save(new User(1, "a", "b"));
        crud.save(new User(2, "c", "d"));
        Assertions.assertEquals(2, crud.count());
    }

    @Test
    public void testDeleteAllWhenIsEmpty() {
        crud.deleteAll();
        Assertions.assertEquals(0, crud.count());
    }

    @Test
    public void testDeleteAllWhenContains2Entities() {
        crud.save(new User(1, "a", "b"));
        crud.save(new User(2, "c", "d"));
        crud.deleteAll();
        Assertions.assertEquals(0, crud.count());
    }

    @Test
    public void testFindAllWhenEmpty() {
        Assertions.assertEquals(0, crud.findAll().size());
    }

    @Test
    public void testFindAllWhenContains3Entities() {
        crud.save(new User(1, "a", "b"));
        crud.save(new User(2, "c", "d"));
        crud.save(new User(3, "e", "f"));
        Assertions.assertEquals(3, crud.count());
        Assertions.assertEquals("b", crud.findById(1).getFirstName());
        Assertions.assertEquals("a", crud.findById(1).getUsername());
        Assertions.assertEquals("c", crud.findById(2).getUsername());
        Assertions.assertEquals("d", crud.findById(2).getFirstName());
    }
}