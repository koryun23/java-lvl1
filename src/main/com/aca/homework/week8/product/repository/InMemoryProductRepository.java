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
            throw new ProductAlreadyExistsException("Product with id = " + product.getId() + " already exists.");
        }
        products[numOfProducts++] = product;
    }

    @Override
    public Product findById(long id) {
        for (Product product : products) {
            if (product == null) break;
            if (product.getId() == id) {
                return product;
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
