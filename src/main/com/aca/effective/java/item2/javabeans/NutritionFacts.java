package com.aca.effective.java.item2.javabeans;

public class NutritionFacts {
    private int servingSize = -1; // required
    private int servings = -1; // required
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int cabrohydrate = 0;

    public NutritionFacts(){}

    // setters

    public void setServingSize(int val){
        servingSize = val;
    }

    public void setServings(int val){
        servings = val;
    }

    public void setCalories(int val){
        calories = val;
    }

    public void setFat(int val) {
        fat = val;
    }

    public void setSodium(int val) {
        sodium = val;
    }

    public void setCabrohydrate(int val) {
        cabrohydrate = val;
    }
}
// the JavaBeans pattern has serious disadvantages of its own. Because construction is split across multiple calls, a
// JavaBean may be in inconsistent state partway through its construction. The class does not have the option of enforcing
// consistency merely by checking the validity of the constructor parameters.
// Attempting to use an object when it's in an inconsistent state may cause failures that are far removed from the code
// containing the bug and hence difficult to debug.
// A related disadvantage is that the JavaBeans pattern precludes the possibility of making a classimmutable.
