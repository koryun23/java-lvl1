package com.aca.homework.week15.sql.generate;

public class Demo {
    public static void main(String[] args) {
        SqlGenerator sql = new SqlGenerator();
        System.out.println(sql.generateInsert(new User("John", 45)));

    }
}
