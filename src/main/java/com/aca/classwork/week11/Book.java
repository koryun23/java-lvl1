package com.aca.classwork.week11;

import java.util.*;

public class Book {

    private final String name;
    private final double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "ab";
        String s3 = "Ab";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));


        Set<Book> books1 = new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(final Book o1, final Book o2){
                return o1.name.compareTo(o2.name);
            }
        });
        books1.add(new Book("effective", 54.99));
        books1.add(new Book("effective", 54.99));
        books1.add(new Book("effective", 54.99));
        books1.add(new Book("effective", 54.99));
        books1.add(new Book("effective", 54.99));
        books1.add(new Book("apushy", 40));

        System.out.println(books1.size());

        if (true)
            return;

        for (Book book : books1) {
            System.out.println(book);
        }
        Book book = new Book(args[0], Double.parseDouble(args[1]));
        System.out.println("We are looking for " + book);

        System.out.println(books1.contains(book));
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name " + name + " price " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Book) {
            Book book = (Book) o;
            return book.name.equals(this.name) && book.price == this.price;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
