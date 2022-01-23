package com.aca.homework.week2.symbolcount;

import java.util.Scanner;

public class SymbolCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text");
        String text = scanner.nextLine();
        System.out.println("Enter a symbol");
        char symbol = scanner.next().charAt(0);
        int count = countSymbols(text, symbol);
        System.out.println(count);
    }
    public static int countSymbols(String text, char ch){
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }
}
