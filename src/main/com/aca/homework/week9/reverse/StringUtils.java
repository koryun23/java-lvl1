package com.aca.homework.week9.reverse;

public class StringUtils {
    private StringUtils() {
    }

    public static String reverse(String string) {
        if (string == null) throw new IllegalArgumentException("Provided string is null.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            sb.append(string.charAt(string.length() - i - 1));
        }

        return sb.toString();
    }
}
