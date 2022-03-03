package com.aca.classwork.week8.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new File("C://Users//Koryun//Desktop//java-lvl1//src//main//com//aca//classwork//week8//file//text.txt")
        );
        for(int i = 0; i < 4; i++) {
            System.out.println(scanner.nextLine());
        }
    }
}
