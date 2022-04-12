package com.aca.homework.week13.entity.info;


@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    private final Long id;

    @Column(name = "NAME")
    private final String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
