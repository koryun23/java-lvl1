package com.aca.homework.week10.mapper;

public class DefaultUserMapper implements UserMapper {
    @Override
    public UserModel map(User user) {
        return new UserModel(user.getUsername(), user.getFirstName());
    }
}
