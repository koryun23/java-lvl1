package com.aca.effective.java.item2.builder;

public class NutritionFactsDemo {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        // this client code is easy to write and easy to read.
    }
}

// The NutritionFacts class is immutable, and all parameter default values are in one place. The Builder's setter methods
// return the builder itself so that invocations can be chained, resulting in a fluent API.