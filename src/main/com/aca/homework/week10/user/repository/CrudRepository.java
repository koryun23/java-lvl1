package com.aca.homework.week10.user.repository;

import java.util.List;

public interface CrudRepository<T> {
    T save(T entity);

    void delete(T entity);

    T findById(long id);

    long count();

    void deleteAll();

    List<T> findAll();
}
