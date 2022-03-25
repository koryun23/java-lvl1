package com.aca.additional.design.patterns.strategy.example1;

public class Main {
    public static void main(String[] args) {
        Strategy strategy1 = new Strategy1();
        Context context = new Context(strategy1);
        System.out.println("(1) " + context.operation());

        Strategy strategy2 = new Strategy2();
        context.setStrategy(strategy2);
        System.out.println("(2) " + context.operation());
    }


}
