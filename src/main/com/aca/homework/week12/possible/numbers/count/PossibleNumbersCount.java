package com.aca.homework.week12.possible.numbers.count;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleNumbersCount {
    public static void main(String[] args) {
        System.out.println(getPossibleNumbersCount());
    }

    public static int getPossibleNumbersCount() {
        int count = 1;
        Set<Integer> numberSet = new HashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> digitsWithNoOccurrenceLimitation = new HashSet<>(List.of(3));
        for (int i = 1; i <= 4; i++) {
            if (digitsWithNoOccurrenceLimitation.contains(i)) {
                count *= 10; // no limitation for the third digit
            } else if (i == 1) { // the first digit
                count *= (numberSet.size() - 1); // omitting the zero
                numberSet.remove(0);
            } else {
                count *= numberSet.size();
                numberSet.remove(i - 1);
            }
        }
        return count;
    }
}
