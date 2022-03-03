package com.aca.classwork.week8.scanner;

import java.util.InputMismatchException;

public class IntSupplierForTest extends IntSupplier{
    private int count;
    @Override
    public int get() {
        count++;
        if(count == 1){
            return 9;
        }
        if(count == 2){
            throw new InputMismatchException();
        }
        if(count == 3){
            return 10;
        }
        if(count == 4){
            throw new InputMismatchException();
        }
        if(count == 5){
            throw new InputMismatchException();
        }
        if (count == 6){
            return 4;
        }
        if(count == 7){
            return 5;
        }
        if(count == 8){
            return 6;
        }
        return -1;
    }
}
