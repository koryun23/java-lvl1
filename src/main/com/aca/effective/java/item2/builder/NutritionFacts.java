package com.aca.effective.java.item2.builder;

public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public static class Builder {
        // required parameters
        private int servingSize;
        private int servings;

        // optional parameters
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}

// the builder pattern combines the safety of the telescoping constructors pattern with the readability of the JavaBeans
// pattern. Instead of making the desired object directly, the client calls a constructor(or static factory) with all of the required
// parameters and gets a Builder object. Then the client calls setter-like methods to set each optional parameter of interest.
// Finally, the clinet calls build() method to generate the object, which is typically immutable. The builder is typically a
// static member class of the class it builds.