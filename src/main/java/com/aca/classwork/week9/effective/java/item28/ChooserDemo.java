package com.aca.classwork.week9.effective.java.item28;

import java.util.List;

public class ChooserDemo {
    public static void main(String[] args) {
        Chooser<Integer> chooser = new Chooser<>(List.of(42, 24, 56));
        System.out.println(chooser.choose());
    }
}
