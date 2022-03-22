package com.aca.effective.java.item2.telescopingconstructor;

public class NutritionFacts {
    private int servingSize; // required
    private int servings; // required
    private int calories;
    private int fat;
    private int sodium;
    private int cabrohydrate;

    public NutritionFacts(int servingSize, int servings){
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories){
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat){
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium){
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int cabrohydrate){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.cabrohydrate = cabrohydrate;
    }
}

// The telescoping constructor pattern works, but it is hard to write client code when there are many parameters, and harder still to read it.
// The reader is left wondering what all those values mean and must carefully count parameters to find out.
