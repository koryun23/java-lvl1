package com.aca.homework.week7.button.click;

class ButtonTest {
    public static void main(String[] args) {
        Action action = new Action() {
            @Override
            public void doAction() {
                System.out.println("clicked on the button");
            }
        };

        Button button = new Button("click me", action);
        button.click();
        button.click();
    }
}