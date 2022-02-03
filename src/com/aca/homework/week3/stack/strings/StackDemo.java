package com.aca.homework.week3.stack.strings;

public class StackDemo {
    /*
    Create a Stack class that has push and pop methods.
    The user should be able to push a string value on top of the stack and pop out of the stack.
    The Stack can take up to 10 string values.
    push "main", "push", "push", "push" and pop  4 times and print the popped values.
    note: all variables of The Stack class must be private.
    */
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("main");
        stack.push("push");
        stack.push("push");
        stack.push("push");
        for(int i  =0; i < 4; i++){
            String poppedElement = stack.pop();
            System.out.println(poppedElement);
        }
    }
}
