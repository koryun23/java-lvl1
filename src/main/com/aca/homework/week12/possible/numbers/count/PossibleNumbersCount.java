package com.aca.homework.week12.possible.numbers.count;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleNumbersCount {
    public static void main(String[] args) {
        System.out.println(getPossibleNumbersCount());
    }

    public static int getPossibleNumbersCount(){
        int count = 1;
        Set<Integer> numberSet = new HashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for(int i = 0; i < 4; i++) {
            if(i == 2) {
                count *= 10; // no limitation for the third digit
            } else if(i == 0) {
                count *= (numberSet.size()-1); // omitting the zero
                numberSet.remove(0);
            } else if(i == 1) {
                count *= (numberSet.size());
                numberSet.remove(1);
            } else {
                count *= numberSet.size();
                numberSet.remove(2);
            }
        }
        return count;
    }
}
