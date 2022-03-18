package com.aca.homework.week10.user.repository;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements CrudRepository<User> {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    @Override
    public User save(User entity) {
        if (entity == null)
            throw new IllegalArgumentException("Provided user is null.");
        User userInUsersRepository = findById(entity.getId());
        if (userInUsersRepository == null) {
            users.add(entity);
        } else {
            updateUser(userInUsersRepository, entity);
        }
        return entity;
    }

    @Override
    public void delete(User entity) {
        long startingCount = count();
        users.remove(entity);
        if (count() == startingCount) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public void deleteAll() {
        users.clear();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    public void updateUser(User userToUpdate, User newUser) {
        userToUpdate.setUsername(newUser.getUsername());
        userToUpdate.setFirstName(newUser.getFirstName());
        userToUpdate.setId(newUser.getId());
    }
}
