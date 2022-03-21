package com.aca.exam.exam2;

public class Order {
    private final int id;
    private final String name;
    int price;
    User purchasedUser;

    public Order(int id, String name, int price, User purchasedUser) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasedUser = purchasedUser;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public User getPurchasedUser() {
        return purchasedUser;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Order) {
            Order other = (Order) obj;
            return other.price == price && other.purchasedUser.equals(purchasedUser) && other.id == id && other.name.equals(name);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "id: %s\nname: %s\nprice: %d\npurchased user: %s",
                id, name, price, purchasedUser
        );
    }
}
