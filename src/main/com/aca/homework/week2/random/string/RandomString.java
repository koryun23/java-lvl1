package com.aca.homework.week2.random.string;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'w', '7', '8', '9', 'u'};
        for(int i = 0; i < 10; i++){
            String randomString = generateRandomString(chars);
            System.out.println(randomString);
        }
    }
    public static String generateRandomString(char[] symbols){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < symbols.length; i++){
            int randomInt = new Random().nextInt(symbols.length);
            char randomChar = symbols[randomInt];
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
