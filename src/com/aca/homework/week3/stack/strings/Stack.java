package com.aca.homework.week3.stack.strings;

public class Stack {
    private String[] stack = new String[10];
    private int numOfElements = 0;
    public void push(String s){
        stack[numOfElements++] = s;
    }

    public String pop(){
        stack[numOfElements--] = null;
        return stack[numOfElements];
    }
}
