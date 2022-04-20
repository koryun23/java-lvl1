package com.aca.homework.week13.race.condition.list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RaceConditionGenerator raceConditionGenerator = new RaceConditionGenerator(() -> new Scanner(System.in).nextBoolean());
        System.out.println(raceConditionGenerator.start());
    }
}
