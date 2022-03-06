package com.aca.homework.week8.product.repository;

public class InMemoryProductRepository implements ProductRepository {
    private final Product[] products = new Product[10000];
    private int numOfProducts;

    @Override
    public void save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Provided product is null.");
        }
        if (findById(product.getId()) != null) {
            throw new ProductAlreadyExistsException(product.getId());
        }
        products[numOfProducts++] = product;
    }

    @Override
    public Product findById(long id) {
        for (int i = 0; i < numOfProducts; i++) {
            if (products[i] == null) break;
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    @Override
    public Product getById(long id) {
        for (Product product : products) {
            if (product == null) break;
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with id = " + id + "is not found.");
    }

    public int getNumOfProducts() {
        return numOfProducts;
    }
}
