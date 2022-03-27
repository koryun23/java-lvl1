package com.aca.effective.java.objects.item2.telescopingconstructor;

public class NutritionFactsDemo {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
        // Typically, this constructor invocation will require many parameters that you don't want to set, but you are forced
        // to pass a value for them anyway. In this case we passed value 0 for fat. With only 6 parameters this may not seem
        // too bad, but it quickly goes out of hand as the parameters increases.
    }
}
