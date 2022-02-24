package com.aca.classwork.week6.set;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraySetTest {
    private Set testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new ArraySet();
    }

    @Test
    public void testSizeWhenIsEmpty(){
        Assertions.assertEquals(0, testSubject.size());
    }

    @Test
    public void testSizeWhenContainsOnlyOneUser(){
        testSubject.add(new User("f","l"));
        Assertions.assertEquals(1, testSubject.size());
    }

    @Test
    public void testSizeWhen5SameUsersWereAdded(){
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));

        Assertions.assertEquals(5, testSubject.size());
    }
}