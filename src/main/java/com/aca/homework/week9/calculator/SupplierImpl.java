package com.aca.homework.week9.calculator;

import java.util.Scanner;

public class SupplierImpl implements StringSupplier{

    @Override
    public String get() {
        return new Scanner(System.in).nextLine();
    }
}
