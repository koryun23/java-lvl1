package com.aca.homework.week10.user.repository;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(User entity) {
        super(String.format("Entity with id = %o, username = %s, first name = %s", entity.getId(), entity.getUsername(), entity.getFirstName()));
    }
}
