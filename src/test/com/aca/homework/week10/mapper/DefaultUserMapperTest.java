package com.aca.homework.week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {
    @Test
    public void testMap(){
        User user = new User(1, "student", "Lord");
        UserMapper mapper = new DefaultUserMapper();
        Assertions.assertEquals(user.getFirstName(), mapper.map(user).getFirstName());
        Assertions.assertEquals(user.getUsername(), mapper.map(user).getUsername());
    }
}