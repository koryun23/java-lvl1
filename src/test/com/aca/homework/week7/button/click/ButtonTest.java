package com.aca.homework.week7.button.click;

class ButtonTest {
    public static void main(String[] args) {
        Button button = new Button("click me");

        Action action = new Action() {
            @Override
            public void doAction() {
                System.out.println("clicked on the button");
            }
        };

        button.click(action);
        button.click(action);
    }
}