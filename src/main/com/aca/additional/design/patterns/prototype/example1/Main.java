package com.aca.additional.design.patterns.prototype.example1;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(new Product1("Product1"));
        System.out.println(client.operation());
    }
}
