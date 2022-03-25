package com.aca.additional.design.patterns.strategy.example1;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String operation() {
        return "Context: Delegating an algorithm to a strategy: Result = " + strategy.algorithm();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
