package com.aca.homework.week10.list.copy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListUtilsTest {
    @Test
    public void testCopy() {
        List<String> original = List.of("a", "b", "c");
        List<String> copy = ListUtils.copy(original);
        Assertions.assertNotSame(copy, original);
        Assertions.assertEquals(copy.get(0), original.get(0));
        Assertions.assertEquals(copy.get(1), original.get(1));
        Assertions.assertEquals(copy.get(2), original.get(2));
    }
}