package com.aca.exam.exam2;

import com.aca.homework.week8.product.repository.Nullable;

import java.io.FileNotFoundException;
import java.util.List;

public interface CrudRepository<ENTITY, ID> {
    @Nullable
    ENTITY findById(ID id) throws FileNotFoundException;

    List<ENTITY> findAll() throws FileNotFoundException;
}
