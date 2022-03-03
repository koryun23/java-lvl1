package com.aca.homework.week8.product.repository;

public class Product{
    private long id;
    private String name;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof Product){
            Product other = (Product) obj;
            return this.id == other.id && this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Product id: %d, name: %s", this.id, this.name);
    }
}

