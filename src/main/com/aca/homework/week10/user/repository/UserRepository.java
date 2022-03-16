package com.aca.homework.week10.user.repository;

import java.util.ArrayList;
import java.util.List;

public class UserRepository<T extends User> implements CrudRepository<T> {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    @Override
    public T save(T entity) {
        if (entity == null)
            throw new IllegalArgumentException("Provided user is null.");
        User userInUsersRepository = (findById(entity.getId()));
        if (userInUsersRepository == null) {
            users.add(entity);
        } else {
            updateUser(userInUsersRepository, entity);
        }
        return entity;
    }

    @Override
    public void delete(T entity) {
        long startingCount = count();
        users.remove(entity);
        if (count() == startingCount) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return (T) user;
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
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) users;
    }

    public void updateUser(User userToUpdate, User newUser) {
        userToUpdate.setUsername(newUser.getUsername());
        userToUpdate.setFirstName(newUser.getFirstName());
        userToUpdate.setId(newUser.getId());
    }
}
