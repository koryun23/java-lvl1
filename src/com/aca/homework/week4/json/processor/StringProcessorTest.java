package com.aca.homework.week4.json.processor;

import java.util.Scanner;

public class StringProcessorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringProcessor json = new StringProcessor(scanner.nextLine());
        System.out.println(json.getValue("name"));
        System.out.println(json.getValue("surname"));
        System.out.println(json.getValue("age"));
        System.out.println(json.getValue("agee"));

    }
}
