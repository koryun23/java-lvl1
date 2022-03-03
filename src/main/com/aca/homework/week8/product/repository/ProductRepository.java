package com.aca.homework.week8.product.repository;

@Respository
public interface ProductRepository {
    void save(Product product);

    @Nullable
    Product findById(long id);

    @NotNull
    Product getById(long id);

}
