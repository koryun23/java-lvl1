package com.aca.homework.week15.repository.employee;

import java.util.List;

public interface CrudRepository<T, ID> {
    void save(T t);

    List<T> findAll();

    T findById(ID id);

    void deleteAll();
}

