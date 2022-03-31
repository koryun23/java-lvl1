package com.aca.homework.week12.snake;

import java.util.Scanner;
import java.util.function.Supplier;

public class MoveSupplierForGame implements Supplier<String> {

    private Scanner scanner;

    @Override
    public String get() {
        if(scanner == null)
            scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
