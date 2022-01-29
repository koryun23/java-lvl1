package com.aca.homework.week3.stack.strings;

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("main");
        stack.push("push");
        stack.push("push");
        stack.push("push");
        for(int i  =0; i < 4; i++){
            stack.pop();
        }
    }
}
